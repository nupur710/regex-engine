package org.regexengine;
//to match \\w
public class WordMatcher extends Matcher {
    private char ch1;
    public WordMatcher(char ch1) {
        this.ch1= ch1;
    }

    @Override
    boolean matches(char ch) {
        return ((ch>= 65 && ch<= 90) ||
                (ch>= 97 && ch<= 122) ||
                (ch>= 48 && ch<= 57) ||
                (ch== 95));
    }
}
