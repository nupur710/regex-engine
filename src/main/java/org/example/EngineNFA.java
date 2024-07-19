package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

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

    static class StackElement {
        int i;
        State currentState;
        StackElement(int i, State currentState) {
            this.i= i;
            this.currentState= currentState;
        }
    }

    boolean compute(String str) {
        Stack<StackElement> stateStack= new Stack<>();
        stateStack.push(new StackElement(0, this.stateList.get(this.initialState.getName())));
        while(!stateStack.isEmpty()) {
            StackElement stackElement= stateStack.pop();
            State currentState= stackElement.currentState;
            int i= stackElement.i;
            if(this.finalStates.contains(stackElement.currentState)) {
                return true;
            }

            if(i < str.length()) {
                char ch= str.charAt(i);
                List<Transition> transitions= currentState.getTransitions();
                for(int j= transitions.size()-1; j >= 0; j--) {
                    Transition transition= transitions.get(j);
                    Matcher matcher= transition.getMatcher();
                    State toState= transition.getState();

                    if(matcher.matcher(ch)) {
                        int next= matcher.isEpsilon() ? i : i+1;
                        stateStack.push(new StackElement(next, toState));
                    }
                }
            }
        }
        return false;
    }
}