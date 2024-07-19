package org.regexengine;

public class EpsilonMatcher extends Matcher{
    boolean matches() {
        return true;
    }

    boolean isEpsilon() {
        return true;
    }

    String getLabel() {
        return "e";
    }
}
