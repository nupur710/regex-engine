package org.regexengine;

public class CharacterMatcher extends Matcher{

    private char c;
    CharacterMatcher(char c) {
        this.c= c;
    }

    @Override
    boolean matches(char ch) {
        return this.c == ch;
    }

    @Override
    boolean isEpsilon() {
        return false;
    }

    @Override
    String getLabel() {
        return String.valueOf(c);
    }


}
