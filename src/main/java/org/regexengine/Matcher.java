package org.regexengine;

abstract public class Matcher {

     CapturingGroup capturingGroup;

    public void setCapturingGroup(CapturingGroup capturingGroup) {
        this.capturingGroup= capturingGroup;
    }

    boolean matches(char ch) {
        return false;
    }

    boolean isEpsilon() {
        return false;
    }

    String getLabel() {
        return "undefined-matcher";
    }
}