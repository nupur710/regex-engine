package org.regexengine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class EngineNFA {

    public Map<String, State> stateList;
    private State initialState;
    private List<State> finalStates;


    public EngineNFA() {
        stateList= new HashMap<>();
        initialState= null;
        finalStates= new ArrayList<>();
    }

    public void setInitialState(State state) {
        this.initialState= state;
    }

    public void setFinalStates(List<State> stl) {
        for(State stateName : stl) {
            finalStates.add(stateName);
        }
    }

    public void setFinalStates(State state) {
        finalStates.add(state);
    }

    //returns all states in nfa
    public List<State> getAllStates() {
        List<State> allStates= new ArrayList<>();
        for(Map.Entry<String, State> entry : stateList.entrySet()) {
            allStates.add(entry.getValue());
        }
        return allStates;
    }

    //when there is only 1 final state
    public State getFinalState() {
        return finalStates.get(0);
    }

    public void addState(String stateName) {
        stateList.put(stateName, new State(stateName));
    }

    public void declareStates(String... stateNames) {
        for(String n : stateNames) {
            this.addState(n);
        }
    }

    public void addTransition(State fromState, State toState, Matcher matcher) {
        stateList.get(fromState.getName()).addTransition(toState, matcher);
    }

    public State getStateObject(String stateName) {
        return stateList.get(stateName);
    }

    void unshiftTransition(State fromState, State toState, Matcher matcher) {
        stateList.get(fromState.getName()).unshiftTransition(toState, matcher);
    }



    public State getInitialState() {
        return this.initialState;
    }

    public List<State> getFinalStates() {
        return this.finalStates;
    }

    static class StackElement {
        int i;
        State currentState;
        List<String> memory; //use memory to prevent infinite epsilon transition loops

        StackElement(int i, State currentState, List<String> memory) {
            this.i= i;
            this.currentState= currentState;
            this.memory= memory;
        }
    }

    boolean compute(String str) {
        Stack<StackElement> stateStack= new Stack<>();
        stateStack.push(new StackElement(0, this.initialState, new ArrayList<>()));
        while(!stateStack.isEmpty()) {
            StackElement stackElement= stateStack.pop();
            State currentState= stackElement.currentState;
            int i= stackElement.i;
            List<String> memory= stackElement.memory;
            if(this.finalStates.contains(currentState) && i == str.length()) {
                return true;
            }

            List<Transition> transitions= currentState.getTransitions();
            for(int j= transitions.size()-1; j >= 0; j--) {
                Transition transition= transitions.get(j);
                Matcher matcher= transition.getMatcher();
                State toState= transition.getState();
                if(matcher.isEpsilon()) {
                    if(memory.contains(toState.getName())) {
                        continue;
                    }
                    memory.add(currentState.getName());
                    stateStack.add(new StackElement(i, toState, memory));
                } else if(i < str.length() && matcher.matches(str.charAt(i))) {
                    stateStack.add(new StackElement(i+1, toState, memory));
                }
            }
        }
        return false;
    }
}