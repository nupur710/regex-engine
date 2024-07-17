package org.example;

public class Transition {

    private State state;
    private Matcher matcher;
    Transition(State state, Matcher matcher) {
        this.state= state;
        this.matcher= matcher;
    }
}
