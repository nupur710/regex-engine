package thompson_construction;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.regexengine.*;

import java.io.IOException;
import java.util.List;
import java.util.Stack;

public class BuildNFA {
    private List<Token> regexTokensList;
    private Stack<EngineNFA> nfaStack = new Stack<>();
    private int tokenIndex = 0;

    public BuildNFA(CommonTokenStream regexTokens) {
        this.regexTokensList = regexTokens.getTokens();
    }

    public void parseQuantifiers() throws IOException {
        boolean orFlag = false;
        State orState = null;
        while (tokenIndex < regexTokensList.size() && getToken(tokenIndex).getType() != -1) {
            Token token= getToken(tokenIndex);
            switch (token.getType()) {
                case 11: {
                    buildCharacterClass();
                    handleConcatenation(token, orFlag, orState);
                    break;
                }
                case 19: {
                    buildSingleChar(token);
                    handleConcatenation(token, orFlag, orState);
                    break;
                }
                case 8: {
                    buildPlus();
                    break;
                }
                case 7: {
                    buildKleeneStar();
                    break;
                }
                case 10: {
                    buildOptional();
                    break;
                }
                case 1: {
                    orFlag = true;
                    orState = buildOr();
                    break;
                }
                case 3: {
                    buildPredefinedCharacterClass();
                    handleConcatenation(token, orFlag, orState);
                    break;
                }
                default:
                    throw new IOException("Invalid token: " + token);
            }
            tokenIndex++;
        }
    }

    private void handleConcatenation(Token token, boolean orFlag, State orState) {
        if (nfaStack.size() > 1) {
            if (orFlag == true && orState != null) {
                EngineNFA orConcatenated = buildOrConcat(token, orFlag, orState);
                nfaStack.push(orConcatenated);
            } else {
                EngineNFA concatenated = buildConcat();
                nfaStack.push(concatenated);
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
        Matcher matcher= null;
        State previousInitialState=  null, previousFinalState= null,  mid= null, previousMid= null;
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
                if(transition.getState().getName().equals(previousFinalState.getName())) {
                    previousMid= engineNFA2.getStateObject(state.getName());
                    mid= toState;
                }
                if(previousMid != null && state.getName().equals(previousMid.getName())) {
                    matcher= transition.getMatcher();
                    engineNFA2.addTransition(state, toState, new EpsilonMatcher());
                } else {
                    engineNFA2.addTransition(state, toState, transition.getMatcher());
                }
            }
        }
        engineNFA2.declareStates("q0_fin", "q1_fin");
        State beforeFinal= engineNFA2.getStateObject("q0_fin");
        State finalState= engineNFA2.getStateObject("q1_fin");
        engineNFA2.setInitialState(previousInitialState);
        engineNFA2.setFinalStates(finalState);
        engineNFA2.addTransition(previousMid, finalState, new EpsilonMatcher());
        engineNFA2.addTransition(mid, beforeFinal, matcher);
        engineNFA2.addTransition(beforeFinal, mid, new EpsilonMatcher());
        engineNFA2.addTransition(beforeFinal, finalState, new EpsilonMatcher());
        nfaStack.add(engineNFA2);
    }

    //for ? quantifier
    void buildOptional() {
        EngineNFA engineNFA1= nfaStack.pop();
        State optionalState= null;
        for(State state : engineNFA1.getAllStates()) {
            for(Transition transition : state.getTransitions()) {
                if(transition.getState() == engineNFA1.getFinalState()) {
                    optionalState= state;
                }
            }
        }
        engineNFA1.addTransition(optionalState, engineNFA1.getFinalState(), new EpsilonMatcher());
        nfaStack.add(engineNFA1);
    }

    //for | symbol
    State buildOr() {
        EngineNFA orNFA= nfaStack.pop();
        State previousInitial= orNFA.getInitialState();
        State previousFinal= orNFA.getFinalState();
        orNFA.declareStates("q0_fin", "q1_fin");
        State midState= orNFA.getStateObject("q0_fin");
        State newFinal= orNFA.getStateObject("q1_fin");
        orNFA.overwriteFinalState(newFinal);
        orNFA.addTransition(previousInitial, midState, new EpsilonMatcher());
        orNFA.addTransition(midState, newFinal, new EpsilonMatcher());
        orNFA.addTransition(previousFinal, newFinal, new EpsilonMatcher());
        nfaStack.add(orNFA);
        return midState;
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

    public EngineNFA buildOrConcat(Token token, boolean orFlag, State orState) {
        if(nfaStack.size() == 2) {
            nfaStack.pop();
        }
        EngineNFA engineNFA1= nfaStack.pop();
        State initialState= engineNFA1.getInitialState();
        for(Transition transition : initialState.getTransitions()) {
            if(transition.getState() == orState) {
                transition.setMatcher(new CharacterMatcher(token.getText().charAt(0)));
            }
        }
        orFlag= false;
        return engineNFA1;
    }

    private Token[] tokenBoundary() throws IOException {
        Token[] tokens= new Token[2];
        this.tokenIndex++;
        Token begin= getToken(tokenIndex);
        tokens[0]= begin;
        this.tokenIndex++;
        if(getToken(tokenIndex).getType() != 13) throw new IOException("Expected - ");
        this.tokenIndex++;
        Token end= getToken(tokenIndex);
        this.tokenIndex++;
        tokens[1]= end;
        if(getToken(tokenIndex).getType() != 12) throw new IOException("Expected ] ");
        return tokens;
    }
    public void buildCharacterClass() throws IOException {
        Token[] bd = tokenBoundary();
        Token begin = bd[0];
        Token end = bd[1];
        EngineNFA engineNFA = new EngineNFA();
        engineNFA.declareStates("q0", "q1");
        State initialState = engineNFA.getStateObject("q0");
        State finalState = engineNFA.getStateObject("q1");
        engineNFA.setInitialState(initialState);
        engineNFA.setFinalStates(finalState);
        engineNFA.addTransition(initialState, finalState, new ClassRangeMatcher(begin.getText().charAt(0), end.getText().charAt(0)));
        nfaStack.add(engineNFA);
    }

    private void buildPredefinedCharacterClass() {
        this.tokenIndex++;
        Token token= getToken(tokenIndex);
        char ch= token.getText().charAt(0);
        EngineNFA engineNFA = new EngineNFA();
        engineNFA.declareStates("q0", "q1");
        State initialState = engineNFA.getStateObject("q0");
        State finalState = engineNFA.getStateObject("q1");
        engineNFA.setInitialState(initialState);
        engineNFA.setFinalStates(finalState);
        if(ch=='d') {
            engineNFA.addTransition(initialState, finalState, new DigitMatcher(ch));
        } else if(ch== 'D') {
            engineNFA.addTransition(initialState, finalState, new NonDigitMatcher(ch));
        } else if(ch== 'w') {
            engineNFA.addTransition(initialState, finalState, new WordMatcher(ch));
        } else if(ch== 'W') {
            engineNFA.addTransition(initialState, finalState, new NonWordMatcher(ch));
        } else if(ch== 's') {
            engineNFA.addTransition(initialState, finalState, new WhitespaceMatcher(ch));
        } else if(ch== 'S') {
            engineNFA.addTransition(initialState, finalState, new NonWhitespaceMatcher(ch));
        }
        nfaStack.add(engineNFA);
    }

    private Token getToken(int tokenIndex) {
        return this.regexTokensList.get(tokenIndex);
    }
}
