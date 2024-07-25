package thompson_construction;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.regexengine.*;

import java.util.List;
import java.util.Stack;

public class BuildNFA {

    CommonTokenStream regexTokens;
    Stack<EngineNFA> nfaStack= new Stack<>();
    public BuildNFA(CommonTokenStream regexTokens) {
        this.regexTokens= regexTokens;
    }

    public void parseQuantifiers() {
        for(Token token : regexTokens.getTokens()) {
            switch (token.getType()) {
                case 19: {
                    buildRule2(token);
                    break;
                } case 8: {
                    buildRule3(token);
                }
            }
        }
    }

    //Thompson construction for single character match
    public void buildRule2(Token tokenMatcher) {
        EngineNFA engineNFA= new EngineNFA();
        engineNFA.declareStates("q0", "q1");
        State initialState= engineNFA.getStateObject("q0");
        State finalState= engineNFA.getStateObject("q1");
        engineNFA.setInitialState(initialState);
        engineNFA.setFinalStates(finalState);
        engineNFA.addTransition(initialState, finalState, new CharacterMatcher((char)tokenMatcher.getType()));
        nfaStack.add(engineNFA);
    }

    //Thompson construction for + quantifier
    public void buildRule3(Token tokenMatcher) {
        EngineNFA engineNFA1= nfaStack.pop();
        EngineNFA engineNFA2= new EngineNFA();
        //add all states from engineNFA1 to engineNFA2
        //create new state string name as state.getName_copy
        //add above created state to engineNFA2
        //get the above state using its string name
        //for each transition in state.getTransition()
        //get toState name as string = transiton.getState().getName()_copy
        //get the above in state form
        //add it to above created state in step 1
        for(State state : engineNFA1.getAllStates()) {
            String name= state.getName()+"_copy";
            engineNFA2.addState(name);
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
        engineNFA2.addTransition(initialState, engineNFA1.getInitialState(), new EpsilonMatcher());
        engineNFA2.addTransition(engineNFA1.getFinalState(), finalState, new EpsilonMatcher());
        engineNFA2.addTransition(engineNFA2.getFinalState(), engineNFA2.getInitialState(), new EpsilonMatcher());
    }
}
