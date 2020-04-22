package Entities;

import java.io.Serializable;
import java.util.Objects;

public class WJournalPK implements Serializable {
    private long professorId;
    private long courseId;

    public long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(long professorId) {
        this.professorId = professorId;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WJournalPK that = (WJournalPK) o;
        return professorId == that.professorId &&
                courseId == that.courseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(professorId, courseId);
    }
}
