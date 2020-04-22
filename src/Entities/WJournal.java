package Entities;

public class WJournal {
    private long professorId;
    private long courseId;
    private Professor professorByProfessorId;
    private Course courseByCourseId;

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

    public Professor getProfessorByProfessorId() {
        return professorByProfessorId;
    }

    public void setProfessorByProfessorId(Professor professorByProfessorId) {
        this.professorByProfessorId = professorByProfessorId;
    }

    public Course getCourseByCourseId() {
        return courseByCourseId;
    }

    public void setCourseByCourseId(Course courseByCourseId) {
        this.courseByCourseId = courseByCourseId;
    }
}
