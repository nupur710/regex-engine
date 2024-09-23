package org.regexengine;

public class ClassRangeMatcher extends Matcher{
    private char ch1, ch2;

    public ClassRangeMatcher(char ch1, char ch2) {
        this.ch1= ch1;
        this.ch2= ch2;
    }

    @Override
    boolean matches(char c) {
        return c>=this.ch1 && c<=this.ch2;
    }

    @Override
    boolean isClassRangeMatcher() {
        return true;
    }

}
