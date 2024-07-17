package org.example;

public class CharacterMatcher extends Matcher{

    private char c;
    CharacterMatcher(char c) {
        this.c= c;
    }

    boolean matches(char ch) {
        return this.c == ch;
    }

    boolean isEpsilon() {
        return false;
    }

    String getLabel() {
        return String.valueOf(c);
    }


}
