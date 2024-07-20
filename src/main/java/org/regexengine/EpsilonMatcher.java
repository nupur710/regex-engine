package org.regexengine;

public class EpsilonMatcher extends Matcher {

    @Override
    boolean matches(char ch) {
        return true;
    }

    @Override
    boolean isEpsilon() {
        return true;
    }

    @Override
    String getLabel() {
        return "e";
    }
}
