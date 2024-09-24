package org.regexengine;
//to match \\D
public class NonDigitMatcher extends Matcher {
    private char ch1;
    public NonDigitMatcher(char ch1) {
        this.ch1= ch1;
    }

    @Override
    boolean matches(char ch) {
        return (ch < 48 || ch > 57);
    }
}
