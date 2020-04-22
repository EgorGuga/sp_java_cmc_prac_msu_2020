package Entities;

import java.util.Set;

public class Course {
    private long courseId;
    private String name;
    private String coverage;
    private int intensity;
    private Integer yearOfStudy;
    private int year;
    private byte active;
    private Set<Clazz> classesByCourseId;
    private Set<WJournal> wJournalsByCourseId;

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoverage() {
        return coverage;
    }

    public void setCoverage(String coverage) {
        this.coverage = coverage;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(Integer yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public byte getActive() {
        return active;
    }

    public void setActive(byte active) {
        this.active = active;
    }

    public Set<Clazz> getClassesByCourseId() {
        return classesByCourseId;
    }

    public void setClassesByCourseId(Set<Clazz> classesByCourseId) {
        this.classesByCourseId = classesByCourseId;
    }

    public Set<WJournal> getwJournalsByCourseId() {
        return wJournalsByCourseId;
    }

    public void setwJournalsByCourseId(Set<WJournal> wJournalsByCourseId) {
        this.wJournalsByCourseId = wJournalsByCourseId;
    }
}
