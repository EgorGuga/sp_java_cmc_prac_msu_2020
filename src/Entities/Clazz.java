package Entities;

import java.sql.Time;
import java.util.Set;

public class Clazz {
    private long classId;
    private String dayOfTheWeek;
    private Time startTime;
    private Time endTime;
    private Course courseByCourseId;
    private Professor professorByProfessorId;
    private LectureHall lectureHallByLectureHallId;
    private Set<SJournal> sJournalsByClassId;

    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public void setDayOfTheWeek(String dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Course getCourseByCourseId() {
        return courseByCourseId;
    }

    public void setCourseByCourseId(Course courseByCourseId) {
        this.courseByCourseId = courseByCourseId;
    }

    public Professor getProfessorByProfessorId() {
        return professorByProfessorId;
    }

    public void setProfessorByProfessorId(Professor professorByProfessorId) {
        this.professorByProfessorId = professorByProfessorId;
    }

    public LectureHall getLectureHallByLectureHallId() {
        return lectureHallByLectureHallId;
    }

    public void setLectureHallByLectureHallId(LectureHall lectureHallByLectureHallId) {
        this.lectureHallByLectureHallId = lectureHallByLectureHallId;
    }

    public Set<SJournal> getsJournalsByClassId() {
        return sJournalsByClassId;
    }

    public void setsJournalsByClassId(Set<SJournal> sJournalsByClassId) {
        this.sJournalsByClassId = sJournalsByClassId;
    }
}
