package Entities;

public class SJournal {
    private long studentId;
    private long classId;
    private Student studentByStudentId;
    private Clazz classByClassId;

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

    public Student getStudentByStudentId() {
        return studentByStudentId;
    }

    public void setStudentByStudentId(Student studentByStudentId) {
        this.studentByStudentId = studentByStudentId;
    }

    public Clazz getClassByClassId() {
        return classByClassId;
    }

    public void setClassByClassId(Clazz clazzByClassId) {
        this.classByClassId = clazzByClassId;
    }
}
