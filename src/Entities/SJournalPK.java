package Entities;

import java.io.Serializable;
import java.util.Objects;

public class SJournalPK implements Serializable {
    private long studentId;
    private long classId;

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SJournalPK that = (SJournalPK) o;
        return studentId == that.studentId &&
                classId == that.classId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, classId);
    }
}
