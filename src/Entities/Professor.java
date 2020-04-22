package Entities;

import java.util.Set;

public class Professor {
    private long professorId;
    private String fullName;
    private Set<Clazz> classesByProfessorId;
    private Set<WJournal> wJournalsByProfessorId;

    public long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(long professorId) {
        this.professorId = professorId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<Clazz> getClassesByProfessorId() {
        return classesByProfessorId;
    }

    public void setClassesByProfessorId(Set<Clazz> classesByProfessorId) {
        this.classesByProfessorId = classesByProfessorId;
    }

    public Set<WJournal> getwJournalsByProfessorId() {
        return wJournalsByProfessorId;
    }

    public void setwJournalsByProfessorId(Set<WJournal> wJournalsByProfessorId) {
        this.wJournalsByProfessorId = wJournalsByProfessorId;
    }
}
