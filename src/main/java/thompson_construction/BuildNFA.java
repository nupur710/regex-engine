package thompson_construction;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.regexengine.*;

import java.util.List;
import java.util.Stack;

public class BuildNFA {

    private CommonTokenStream regexTokens;
    private Stack<EngineNFA> nfaStack= new Stack<>();
    public BuildNFA(CommonTokenStream regexTokens) {
        this.regexTokens= regexTokens;
    }

    public void parseQuantifiers() {
        for(Token token : regexTokens.getTokens()) {
            switch (token.getType()) {
                case 19: {
                    buildSingleChar(token);
                    if(nfaStack.size() > 1) {
                        EngineNFA concatenated= buildConcat();
                        nfaStack.push(concatenated);
                    }
                    break;
                } case 8: {
                    buildPlus();
                    break;
                } case 7: {
                    buildKleeneStar();
                    break;
                } case 10: {
                    buildOptional(token);
                    break;
                } case 1: {
                    buildOr();
                    break;
                }
            }
        }
    }

    //Thompson construction for single character match
    public void buildSingleChar(Token tokenMatcher) {
        EngineNFA engineNFA= new EngineNFA();
        engineNFA.declareStates("q0", "q1");
        State initialState= engineNFA.getStateObject("q0");
        State finalState= engineNFA.getStateObject("q1");
        engineNFA.setInitialState(initialState);
        engineNFA.setFinalStates(finalState);
        engineNFA.addTransition(initialState, finalState, new CharacterMatcher(tokenMatcher.getText().charAt(0)));
        nfaStack.add(engineNFA);
    }

    //Thompson construction for + quantifier
    public void buildPlus() {
        EngineNFA engineNFA1= nfaStack.pop();
        EngineNFA engineNFA2= new EngineNFA();
        State previousInitialState= null, previousFinalState= null, midStateToTransition= null;
        for(State state : engineNFA1.getAllStates()) {
            engineNFA2.addState(state.getName());
            if(state == engineNFA1.getInitialState()) {
                previousInitialState= engineNFA2.getStateObject(state.getName());
            }
            if(state == engineNFA1.getFinalState()) {
                previousFinalState= engineNFA2.getStateObject(state.getName());
            }
        }
        for(State state : engineNFA1.getAllStates()) {
            for(Transition transition : state.getTransitions()) {
                String toStateName= transition.getState().getName();
                State toState= engineNFA2.getStateObject(toStateName);
                if(toState.getName().equals(previousFinalState.getName())) {
                    midStateToTransition= engineNFA2.getStateObject(state.getName());
                }
                engineNFA2.addTransition(state, toState, transition.getMatcher());
            }
        }
        engineNFA2.declareStates("q0_fin", "q1_fin");
        State initialState= engineNFA2.getStateObject("q0_fin");
        State finalState= engineNFA2.getStateObject("q1_fin");
        engineNFA2.setInitialState(initialState);
        engineNFA2.setFinalStates(finalState);
        engineNFA2.addTransition(initialState, previousInitialState, new EpsilonMatcher());
        engineNFA2.addTransition(previousFinalState, finalState, new EpsilonMatcher());
        engineNFA2.addTransition(previousFinalState, midStateToTransition, new EpsilonMatcher());
        nfaStack.add(engineNFA2);
    }

    //Thompson construction for * quantifer
    public void buildKleeneStar() {
        EngineNFA engineNFA1= nfaStack.pop();
        EngineNFA engineNFA2= new EngineNFA();
        State prevInitialState= null;
        State prevFinalState= null;
        for(State state : engineNFA1.getAllStates()) {
            String name= state.getName()+"_copy";
            engineNFA2.addState(name);
            if(state == engineNFA1.getInitialState()) {
                prevInitialState= engineNFA2.getStateObject(name);
            }
            if(state == engineNFA1.getFinalState()) {
                prevFinalState= engineNFA2.getStateObject(name);
            }
            State getState= engineNFA2.getStateObject(name);
            for(Transition transition : state.getTransitions()) {
                Matcher matcher= transition.getMatcher();
                String toStateName= transition.getState().getName()+"_copy";
                State getToState= engineNFA2.getStateObject(toStateName);
                engineNFA2.addTransition(getState, getToState, matcher);
            }
        }
        engineNFA2.declareStates("q0", "q1");
        State initialState= engineNFA2.getStateObject("q0");
        State finalState= engineNFA2.getStateObject("q1");
        engineNFA2.setInitialState(initialState);
        engineNFA2.setFinalStates(finalState);
        engineNFA2.addTransition(initialState, finalState, new EpsilonMatcher());
        engineNFA2.addTransition(initialState, prevInitialState, new EpsilonMatcher());
        engineNFA2.addTransition(prevFinalState, finalState, new EpsilonMatcher());
        engineNFA2.addTransition(prevFinalState, prevInitialState, new EpsilonMatcher());
        nfaStack.add(engineNFA2);
    }

    //for ? quantifier
    void buildOptional(Token tokenMatcher) {
        EngineNFA engineNFA1= nfaStack.pop();
        EngineNFA engineNFA2= new EngineNFA();
        State prevInitialState= null;
        State prevFinalState= null;
        for(State state : engineNFA1.getAllStates()) {
            String name= state.getName()+"_copy";
            engineNFA2.addState(name);
            if(state == engineNFA1.getInitialState()) {
                prevInitialState= engineNFA2.getStateObject(name);
            }
            if(state == engineNFA1.getFinalState()) {
                prevFinalState= engineNFA2.getStateObject(name);
            }
            State getState= engineNFA2.getStateObject(name);
            for(Transition transition : state.getTransitions()) {
                Matcher matcher= transition.getMatcher();
                String toStateName= transition.getState().getName()+"_copy";
                State getToState= engineNFA2.getStateObject(toStateName);
                engineNFA2.addTransition(getState, getToState, matcher);
            }
        }
        engineNFA2.declareStates("q0", "q1");
        State initialState= engineNFA2.getStateObject("q0");
        State finalState= engineNFA2.getStateObject("q1");
        engineNFA2.setInitialState(initialState);
        engineNFA2.setFinalStates(finalState);
        engineNFA2.addTransition(initialState, prevInitialState, new EpsilonMatcher());
        engineNFA2.addTransition(prevFinalState, finalState, new CharacterMatcher(tokenMatcher.getText().charAt(0)));
        engineNFA2.addTransition(initialState, finalState, new EpsilonMatcher());
        nfaStack.add(engineNFA2);
    }

    //for | symbol
    void buildOr() {
        EngineNFA engineNFA1= nfaStack.pop();
        EngineNFA engineNFA2= nfaStack.pop();
        EngineNFA engineNFA3= new EngineNFA();
        engineNFA3.declareStates("q0", "q1");
        State initialState= engineNFA3.getStateObject("q0");
        State finalState= engineNFA3.getStateObject("q1");
        engineNFA3.setInitialState(initialState);
        engineNFA3.setFinalStates(finalState);
        engineNFA3.addTransition(initialState, engineNFA1.getInitialState(), new EpsilonMatcher());
        engineNFA3.addTransition(finalState, engineNFA2.getInitialState(), new EpsilonMatcher());
        engineNFA3.addTransition(engineNFA1.getFinalState(), finalState, new EpsilonMatcher());
        engineNFA3.addTransition(engineNFA2.getFinalState(), finalState, new EpsilonMatcher());
        nfaStack.add(engineNFA3);
    }

    public EngineNFA getFinalEngine() {
        return nfaStack.pop();
    }

    private EngineNFA buildConcat() {
        EngineNFA concatenatedNFA= new EngineNFA();
        EngineNFA rightNFA= nfaStack.pop();
        EngineNFA leftNFA= nfaStack.pop();
        String leftInitialStateName= leftNFA.getInitialState().getName()+"_left";
        String leftFinalStateName= leftNFA.getFinalState().getName()+"_left";
        String rightInitialStateName= rightNFA.getInitialState().getName()+"_right";
        String rightFinalStateName= rightNFA.getFinalState().getName()+"_right";
        //add all states & transitions from right nfa to concatenated nfa
        for(State state : rightNFA.getAllStates()) {
            concatenatedNFA.addState(state.getName() + "_right");
        }
        for(State state : rightNFA.getAllStates()) {
            for(Transition transition : state.getTransitions()) {
                State fromState= concatenatedNFA.getStateObject(state.getName()+"_right");
                String toStateName= transition.getState().getName()+"_right";
                State toState= concatenatedNFA.getStateObject(toStateName);
                concatenatedNFA.addTransition(fromState, toState, transition.getMatcher());
            }
        }

        //add all states & transitions from left nfa to concatenated nfa
        for(State state : leftNFA.getAllStates()) {
            concatenatedNFA.addState(state.getName() + "_left");
        }
        for(State state : leftNFA.getAllStates()) {
            for(Transition transition : state.getTransitions()) {
                State fromState= concatenatedNFA.getStateObject(state.getName()+"_left");
                String toStateName= transition.getState().getName()+"_left";
                State toState= concatenatedNFA.getStateObject(toStateName);
                concatenatedNFA.addTransition(fromState, toState, transition.getMatcher());
            }
        }
        State newInitialState= concatenatedNFA.getStateObject(leftInitialStateName);
        concatenatedNFA.setInitialState(newInitialState);
        State newFinalState= concatenatedNFA.getStateObject(rightFinalStateName);
        concatenatedNFA.setFinalStates(newFinalState);
        concatenatedNFA.addTransition(concatenatedNFA.getStateObject(leftFinalStateName), concatenatedNFA.getStateObject(rightInitialStateName), new EpsilonMatcher());
        return concatenatedNFA;
    }
}
