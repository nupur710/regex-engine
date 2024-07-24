package thompson_construction;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.regexengine.CharacterMatcher;
import org.regexengine.EngineNFA;
import org.regexengine.State;

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

    public void buildRule3(Token tokenMatcher) {
        EngineNFA engineNFA1= nfaStack.pop();
        EngineNFA engineNFA2= nfaStack.pop();
        EngineNFA engineNFA3= new EngineNFA();
    }

}
