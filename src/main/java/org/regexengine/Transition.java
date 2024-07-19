package org.regexengine;

public class Transition {

    private State state;
    private Matcher matcher;
    Transition(State state, Matcher matcher) {
        this.state= state;
        this.matcher= matcher;
    }

    public State getState() {
        return state;
    }

    public Matcher getMatcher() {
        return matcher;
    }
}
