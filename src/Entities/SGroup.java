package Entities;

import java.util.Set;

public class SGroup {
    private long groupId;
    private int groupNumber;
    private Flow flowByFlowId;
    private Set<Student> studentsByGroupId;

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Flow getFlowByFlowId() {
        return flowByFlowId;
    }

    public void setFlowByFlowId(Flow flowByFlowId) {
        this.flowByFlowId = flowByFlowId;
    }

    public Set<Student> getStudentsByGroupId() {
        return studentsByGroupId;
    }

    public void setStudentsByGroupId(Set<Student> studentsByGroupId) {
        this.studentsByGroupId = studentsByGroupId;
    }
}
