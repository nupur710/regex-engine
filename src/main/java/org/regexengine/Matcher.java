package org.regexengine;

abstract public class Matcher {

    boolean matches(char ch) {
        return false;
    }

    boolean isEpsilon() {
        return false;
    }

    abstract boolean isClassRangeMatcher();

    String getLabel() {
        return "undefined-matcher";
    }
}