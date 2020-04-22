package Entities;

import java.util.Set;


public class Student {
    private long studentId;
    private String fullName;
    private int yearOfStudy;
    private Set<SJournal> sJournalsByStudentId;
    private SGroup sGroupByGroupId;
    private Flow flowByFlowId;

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public Set<SJournal> getsJournalsByStudentId() {
        return sJournalsByStudentId;
    }

    public void setsJournalsByStudentId(Set<SJournal> sJournalsByStudentId) {
        this.sJournalsByStudentId = sJournalsByStudentId;
    }

    public SGroup getsGroupByGroupId() {
        return sGroupByGroupId;
    }

    public void setsGroupByGroupId(SGroup sGroupByGroupId) {
        this.sGroupByGroupId = sGroupByGroupId;
    }

    public Flow getFlowByFlowId() {
        return flowByFlowId;
    }

    public void setFlowByFlowId(Flow flowByFlowId) {
        this.flowByFlowId = flowByFlowId;
    }
}
