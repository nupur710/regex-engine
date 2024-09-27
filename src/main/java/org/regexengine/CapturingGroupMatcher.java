package org.regexengine;

public class CapturingGroupMatcher extends Matcher {
    @Override
    boolean matches(char ch) {
        if(capturingGroup != null) return true;
        else return false;
    }
}
