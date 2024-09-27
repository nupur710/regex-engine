package org.regexengine;

public class CapturingGroup {
    private int groupNo;
    private EngineNFA groupNFA;
    private int startIndex;
    private int endIndex;

    public CapturingGroup(int groupNo, EngineNFA groupNFA, int startIndex, int endIndex) {
        this.groupNo= groupNo;
        this.groupNFA= groupNFA;
        this.startIndex= startIndex;
        this.endIndex= endIndex;
    }

    public void setStartAndEndIndex(int start, int end) {
        this.startIndex= start;
        this.endIndex= end;
    }

    public int getGroupNo() {
        return groupNo;
    }

    public EngineNFA getGroupNFA() {
        return groupNFA;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }
}
