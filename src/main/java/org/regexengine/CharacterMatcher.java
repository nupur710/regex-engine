package org.regexengine;

public class CharacterMatcher extends Matcher{

    private char c, ch1, ch2;

    //to keep track of class matching
    public boolean b;
    public CharacterMatcher(char c) {
        this.c= c;
        this.b= false;
    }

    public CharacterMatcher(char ch1, char ch2) {
        this.ch1= ch1;
        this.ch2= ch2;
        this.b= true;
    }

    @Override
    boolean matches(char ch) {
        return this.c == ch;
    }

    @Override
    boolean isClassMatcher() {
        return this.b;
    }

    @Override
    boolean matches1(char c) {
        return c>=this.ch1 && c<=this.ch2;
    }

    boolean isClassChar() {
        return b;
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
