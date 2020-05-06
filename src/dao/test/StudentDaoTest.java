package dao.test;

import Entities.Student;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static dao.src.FlowDao.findFlowById;
import static dao.src.LectureHallDao.deleteLectureHallById;
import static dao.src.SGroupDao.findSGroupById;
import static dao.src.StudentDao.*;

public class StudentDaoTest {

    @Test
    public void testFindStudentAll() {
        List<Student> L = findStudentAll();
        Assert.assertEquals(36, L.size());
    }

    @Test
    public void testFindStudentById() {
        Student S = findStudentById(1);
        Assert.assertEquals(S.getStudentId(), 1);
        Student S2 = findStudentById(100);
        Assert.assertEquals(S2, null);
    }

    @Test
    public void testFindStudentByYOS() {
        List<Student> L = findStudentByYOS(1);
        Set<Long> S = new HashSet<Long>();
        for(Student b : L)
            S.add(b.getStudentId());
        Set<Long> S2 = new HashSet<Long>();
        S2.add((long) 1); S2.add((long) 2); S2.add((long) 3); S2.add((long) 4); S2.add((long) 5); S2.add((long) 6);
        S2.add((long) 7); S2.add((long) 8); S2.add((long) 9); S2.add((long) 10); S2.add((long) 11); S2.add((long) 12);
        S2.add((long) 13); S2.add((long) 14); S2.add((long) 15); S2.add((long) 16); S2.add((long) 17); S2.add((long) 18);
        Assert.assertEquals(S2, S);

        List<Student> L2 = findStudentByYOS(100);
        Assert.assertEquals(L2, null);
    }

    @Test
    public void testFindStudentByYOSAndFlow() {
        List<Student> L = findStudentByYOSAndFlow(1, 2);
        Set<Long> S = new HashSet<Long>();
        for(Student b : L)
            S.add(b.getStudentId());
        Set<Long> S2 = new HashSet<Long>();
        S2.add((long) 7); S2.add((long) 8); S2.add((long) 9); S2.add((long) 10); S2.add((long) 11); S2.add((long) 12);
        Assert.assertEquals(S2, S);

        List<Student> L2 = findStudentByYOSAndFlow(100, 1);
        Assert.assertEquals(L2, null);

        List<Student> L3 = findStudentByYOSAndFlow(1, 100);
        Assert.assertEquals(L3, null);

        List<Student> L4 = findStudentByYOSAndFlow(100, 100);
        Assert.assertEquals(L4, null);
    }

    @Test
    public void testFindStudentByGroup() {
        List<Student> L = findStudentByGroup(102);
        Set<Long> S = new HashSet<Long>();
        for(Student b : L)
            S.add(b.getStudentId());
        Set<Long> S2 = new HashSet<Long>();
        S2.add((long) 4); S2.add((long) 5); S2.add((long) 6);
        Assert.assertEquals(S2, S);

        List<Student> L2 = findStudentByGroup(100);
        Assert.assertEquals(L2, null);
    }

    @Test(dependsOnMethods = {"testFindStudentAll"})
    public void testPersistStudent() {
        Student C = new Student(); C.setStudentId(37); C.setFullName("Сысоев Борис Иванович");
        C.setYearOfStudy(2); C.setFlowByFlowId(findFlowById(3)); C.setsGroupByGroupId(findSGroupById(12));
        persistStudent(C);
        Student C2 = findStudentById(37);
        Assert.assertNotEquals(C2, null);

        Student C3 = new Student(); C3.setStudentId(38);
        persistStudent(C3);
        Student C4 = findStudentById(38);
        Assert.assertEquals(C4, null);
    }

    @Test(dependsOnMethods = {"testPersistStudent"})
    public void testUpdateStudent() {
        Student C = findStudentById(37);
        C.setFullName("Сысоев Борис Владимирович");
        updateStudent(C);
        Student C2 = findStudentById(37);
        Assert.assertEquals(C2.getFullName(), "Сысоев Борис Владимирович");

        Student C3 = findStudentById(37);
        C3.setFullName("Сысоев Борис Владимирович 1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
        updateStudent(C);
        Student C4 = findStudentById(37);
        Assert.assertEquals(C4.getFullName(), "Сысоев Борис Владимирович");
    }

    @Test(dependsOnMethods = {"testUpdateStudent"})
    public void testDeleteStudentById() {
        Student C = findStudentById(37);
        deleteStudentById(C.getStudentId());
        Student C2 = findStudentById(37);
        Assert.assertEquals(C2, null);

        Student C3 = findStudentById(1);
        deleteLectureHallById(C3.getStudentId());
        Student C4 = findStudentById(1);
        Assert.assertNotEquals(C4, null);
    }
}
