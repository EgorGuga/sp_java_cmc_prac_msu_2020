package web.controller.util;

public class StudentAndGroupAndFlow {
    private long studentId;
    private Integer yearOfStudy;
    private String fullName;
    private long flowId;
    private long groupId;

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public Integer getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(Integer yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getFlowId() {
        return flowId;
    }

    public void setFlowId(long flowId) {
        this.flowId = flowId;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }
}
