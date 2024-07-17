package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EngineNFA {

    private Map<String,State> states;
    private State initialState;
    private Set<State> endingState;

    EngineNFA() {
        this.states= new HashMap<>();
        this.initialState= null;
        this.endingState= new HashSet<>();
    }

    void setInitialState(State state) {
        this.initialState= this.states.get(state);
    }

    void setEndingState(Set<String> stateNames) {
        for(String s : stateNames) {
            this.endingState.add(states.get(s));
        }
    }

     void addState(String name) {
        this.states.put(name, new State(name));
    }

     void declareStates(String... names) {
        for (String name : names) {
            this.addState(name);
        }
    }

     void addTransition(String fromState, String toState, Matcher matcher) {
        this.states.get(fromState).addTransition(states.get(toState), matcher);
    }

     void unshiftTransition(String fromState, String toState, Matcher matcher) {
        this.states.get(fromState).unshiftTransition(states.get(toState), matcher);
    }

    void compute(String str) {}

}
