package web.controller.util;

import Entities.Clazz;

public class ClazzExtra {
    private Clazz clazz;
    private long lectureHallId;
    private long professorId;
    private long courseId;
    private String StartHour;
    private String EndHour;
    private String StartMinute;
    private String EndMinute;

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public long getLectureHallId() {
        return lectureHallId;
    }

    public void setLectureHallId(long lectureHallId) {
        this.lectureHallId = lectureHallId;
    }

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

    public String getStartHour() {
        return StartHour;
    }

    public void setStartHour(String startHour) {
        StartHour = startHour;
    }

    public String getEndHour() {
        return EndHour;
    }

    public void setEndHour(String endHour) {
        EndHour = endHour;
    }

    public String getStartMinute() {
        return StartMinute;
    }

    public void setStartMinute(String startMinute) {
        StartMinute = startMinute;
    }

    public String getEndMinute() {
        return EndMinute;
    }

    public void setEndMinute(String endMinute) {
        EndMinute = endMinute;
    }
}
