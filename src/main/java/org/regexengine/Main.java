package org.regexengine;

import java.util.ArrayList;
import java.util.List;

public class Main {

    //Have to specify NFA --> the program constructs an NFA engine
    //use it to test if entered string input matches pattern of NFA

    public static void main(String[] args) {
        EngineNFA engineNFA= new EngineNFA();
        engineNFA.declareStates("q0", "q1", "q2");
        engineNFA.setInitialState(engineNFA.getStateObject("q0"));
        State q3= engineNFA.getStateObject("q2");
        List<State> finalStatesList= new ArrayList<>();
        finalStatesList.add(q3);
        engineNFA.setFinalStates(finalStatesList);
        engineNFA.addTransition(engineNFA.getStateObject("q0"), engineNFA.getStateObject("q1"), new CharacterMatcher('a'));
        engineNFA.addTransition(engineNFA.getStateObject("q1"), engineNFA.getStateObject("q1"), new EpsilonMatcher());
        engineNFA.addTransition(engineNFA.getStateObject("q1"), engineNFA.getStateObject("q2"), new CharacterMatcher('b'));
        System.out.println(engineNFA.compute("ab"));

    }
}