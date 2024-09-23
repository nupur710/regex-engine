package org.regexengine;

abstract public class Matcher {

     boolean matches(char ch) {
        return false;
    }

    abstract boolean isClassMatcher();
    abstract boolean matches1(char c);

    boolean isEpsilon() {
        return false;
    }

    String getLabel() {
        return "undefined-matcher";
    }
}
