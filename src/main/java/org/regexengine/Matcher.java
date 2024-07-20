package org.regexengine;

abstract public class Matcher {

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
