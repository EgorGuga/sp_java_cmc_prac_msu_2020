package Entities;

import java.util.Set;

public class LectureHall {
    private long lectureHallId;
    private String number;
    private Integer capacity;
    private Set<Clazz> classesByLectureHallId;

    public long getLectureHallId() {
        return lectureHallId;
    }

    public void setLectureHallId(long lectureHallId) {
        this.lectureHallId = lectureHallId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Set<Clazz> getClassesByLectureHallId() {
        return classesByLectureHallId;
    }

    public void setClassesByLectureHallId(Set<Clazz> classesByLectureHallId) {
        this.classesByLectureHallId = classesByLectureHallId;
    }
}
