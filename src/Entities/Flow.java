package Entities;

import java.util.Set;

public class Flow {
    private long flowId;
    private int flowNumber;
    private Set<SGroup> sGroupsByFlowId;
    private Set<Student> studentsByFlowId;

    public long getFlowId() {
        return flowId;
    }

    public void setFlowId(long flowId) {
        this.flowId = flowId;
    }

    public int getFlowNumber() {
        return flowNumber;
    }

    public void setFlowNumber(int flowNumber) {
        this.flowNumber = flowNumber;
    }

    public Set<SGroup> getsGroupsByFlowId() {
        return sGroupsByFlowId;
    }

    public void setsGroupsByFlowId(Set<SGroup> sGroupsByFlowId) {
        this.sGroupsByFlowId = sGroupsByFlowId;
    }

    public Set<Student> getStudentsByFlowId() {
        return studentsByFlowId;
    }

    public void setStudentsByFlowId(Set<Student> studentsByFlowId) {
        this.studentsByFlowId = studentsByFlowId;
    }
}
