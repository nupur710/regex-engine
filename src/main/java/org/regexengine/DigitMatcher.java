package org.regexengine;
//to match \\d
public class DigitMatcher extends Matcher {
    private char ch1;
    public DigitMatcher(char ch1) {
        this.ch1= ch1;
    }

    @Override
    boolean matches(char ch) {
        return ch>= 48 && ch<= 57;
    }

}
