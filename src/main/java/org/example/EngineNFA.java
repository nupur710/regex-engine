package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EngineNFA {

    private Map<String, State> stateList;
    private State initialState;
    private List<State> finalStates;


    EngineNFA() {
        stateList= new HashMap<>();
        initialState= null;
        finalStates= new ArrayList<>();
    }

    void setInitialState(State state) {
        this.initialState= state;
    }

    void setFinalStates(List<State> finalStates) {
        for(State state : finalStates) {
            finalStates.add(state);
        }
    }

    void addState(String stateName) {
        stateList.put(stateName, new State(stateName));
    }

    void declareStates(String...stateNames) {
        for(String n : stateNames) {
            this.addState(n);
        }
    }

    void addTransition(State fromState, State toState, Matcher  matcher) {
        stateList.get(fromState.getName()).addTransition(toState, matcher);
    }

    void unshiftTransition(State fromState, State toState, Matcher matcher) {
        stateList.get(fromState.getName()).unshiftTransition(toState, matcher);
    }

    void compute(String str) {

    }

}