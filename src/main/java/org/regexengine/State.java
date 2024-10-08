package org.regexengine;

import java.util.ArrayList;
import java.util.List;

public class State {

    private String name;
    private List<Transition> transitions;
    private List<String> startsGroups;
    private List<String> endsGroups;

    public State(String name) {
        this.name= name;
        this.transitions= new ArrayList<>();
        this.startsGroups= new ArrayList<>();
        this.endsGroups= new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Transition> getTransitions() {
        return transitions;
    }

    void addTransition(State toState, Matcher matcher) {
        this.transitions.add(new Transition(toState, matcher));
    }

    void unshiftTransition(State toState, Matcher matcher) {
        this.transitions.add(0, new Transition(toState, matcher));
    }

}

