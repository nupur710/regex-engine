package org.regexengine;
//to match \\S
public class NonWhitespaceMatcher extends Matcher {
    private char ch1;
    public NonWhitespaceMatcher(char ch1) {
        this.ch1= ch1;
    }

    @Override
    boolean matches(char ch) {
        return (!(ch== ' ' || ch== '\t' ||
                ch== '\n' || ch== '\f' ||
                ch== '\b'));
    }
}
