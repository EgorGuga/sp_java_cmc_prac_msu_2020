package dao.test;

import Entities.Clazz;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Time;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static dao.src.ClazzDao.*;
import static dao.src.CourseDao.findCourseById;
import static dao.src.LectureHallDao.findLectureHallById;
import static dao.src.ProfessorDao.findProfessorById;

public class ClazzDaoTest {

    @Test
    public void testFindClazzAll() {
        List<Clazz> L = findClazzAll();
        Assert.assertEquals(9, L.size());
    }

    @Test
    public void testFindClazzById() {
        Clazz C = findClazzById(1);
        Assert.assertEquals(C.getClassId(), 1);
        Clazz C2 = findClazzById(100);
        Assert.assertEquals(C2, null);
    }

    @Test
    public void testFindClazzByStudent() {
        List<Clazz> L = findClazzByStudent(1);
        Set<Long> S = new HashSet<Long>();
        for(Clazz b : L)
            S.add(b.getClassId());
        Set<Long> S2 = new HashSet<Long>();
        S2.add((long) 1); S2.add((long) 2); S2.add((long) 9);
        Assert.assertEquals(S2, S);

        List<Clazz> L2 = findClazzByStudent(100);
        Assert.assertEquals(L2, null);
    }
    /*
    @Test
    public void testFindClazzByCourse() {
        List<Clazz> L = findClazzByCourse(2);
        Set<Long> S = new HashSet<Long>();
        for(Clazz b : L)
            S.add(b.getClassId());
        Set<Long> S2 = new HashSet<Long>();
        S2.add((long) 3); S2.add((long) 4);
        Assert.assertEquals(S2, S);

        List<Clazz> L2 = findClazzByCourse(100);
        Assert.assertEquals(L2, null);
    }*/

    @Test
    public void testFindClazzByLectureHall() {
        List<Clazz> L = findClazzByLectureHall(1);
        Set<Long> S = new HashSet<Long>();
        for(Clazz b : L)
            S.add(b.getClassId());
        Set<Long> S2 = new HashSet<Long>();
        S2.add((long) 1); S2.add((long) 4);
        Assert.assertEquals(S2, S);

        List<Clazz> L2 = findClazzByLectureHall(100);
        Assert.assertEquals(L2, null);
    }

    @Test
    public void testFindClazzByProfessor() {
        List<Clazz> L = findClazzByProfessor(3);
        Set<Long> S = new HashSet<Long>();
        for(Clazz b : L)
            S.add(b.getClassId());
        Set<Long> S2 = new HashSet<Long>();
        S2.add((long) 5); S2.add((long) 6);
        Assert.assertEquals(S2, S);

        List<Clazz> L2 = findClazzByProfessor(100);
        Assert.assertEquals(L2, null);
    }
    /*
    @Test
    public void testFindClazzByYOF() {
        List<Clazz> L = findClazzByYOS(1);
        Set<Long> S = new HashSet<Long>();
        for(Clazz b : L)
            S.add(b.getClassId());
        Set<Long> S2 = new HashSet<Long>();
        S2.add((long) 1); S2.add((long) 2); S2.add((long) 6); S2.add((long) 5);
        Assert.assertEquals(S2, S);

        List<Clazz> L2 = findClazzByYOS(100);
        Assert.assertEquals(L2, null);
    }*/

    @Test
    public void testFindClazzByGroup() {
        List<Clazz> L = findClazzByGroup(102);
        Set<Long> S = new HashSet<Long>();
        for(Clazz b : L)
            S.add(b.getClassId());
        Set<Long> S2 = new HashSet<Long>();
        S2.add((long) 1); S2.add((long) 2);
        Assert.assertEquals(S2, S);

        List<Clazz> L2 = findClazzByGroup(100);
        Assert.assertEquals(L2, null);
    }

    @Test
    public void testFindClazzByYosAndFlow() {
        List<Clazz> L = findClazzByYosAndFlow(1, 1);
        Set<Long> S = new HashSet<Long>();
        for(Clazz b : L)
            S.add(b.getClassId());
        Set<Long> S2 = new HashSet<Long>();
        S2.add((long) 1); S2.add((long) 2);
        Assert.assertEquals(S2, S);

        List<Clazz> L2 = findClazzByYosAndFlow(100, 100);
        Assert.assertEquals(L2, null);

        List<Clazz> L3 = findClazzByYosAndFlow(1, 100);
        Assert.assertEquals(L3, null);

        List<Clazz> L4 = findClazzByYosAndFlow(100, 100);
        Assert.assertEquals(L4, null);
    }

    @Test(dependsOnMethods = {"testFindClazzAll"})
    public void testPersistClazz() {
        Clazz C = new Clazz(); C.setClassId(10); C.setDayOfTheWeek("вт");
        C.setStartTime(Time.valueOf("09:00:00")); C.setEndTime(Time.valueOf("12:00:00"));
        C.setCourseByCourseId(findCourseById(3)); C.setProfessorByProfessorId(findProfessorById(3));
        C.setLectureHallByLectureHallId(findLectureHallById(3));
        persistClazz(C);
        Clazz C2 = findClazzById(6);
        Assert.assertNotEquals(C2, null);

        Clazz C3 = new Clazz(); C3.setClassId(11);
        C3.setStartTime(Time.valueOf("09:00:00")); C3.setEndTime(Time.valueOf("12:00:00"));
        persistClazz(C3);
        Clazz C4 = findClazzById(11);
        Assert.assertEquals(C4, null);
    }

    @Test(dependsOnMethods = {"testPersistClazz"})
    public void testUpdateClazz() {
        Clazz C = findClazzById(10);
        C.setDayOfTheWeek("ср");
        updateClazz(C);
        Clazz C2 = findClazzById(10);
        Assert.assertEquals(C2.getDayOfTheWeek(), "Ср");

        Clazz C3 = findClazzById(10);
        C3.setDayOfTheWeek("кв");
        updateClazz(C);
        Clazz C4 = findClazzById(10);
        Assert.assertEquals(C4.getDayOfTheWeek(), "Ср");
    }

    @Test(dependsOnMethods = {"testUpdateClazz"})
    public void testDeleteClazzById() {
        Clazz C = findClazzById(10);
        deleteClazzById(C.getClassId());
        Clazz C2 = findClazzById(10);
        Assert.assertEquals(C2, null);

        Clazz C3 = findClazzById(1);
        deleteClazzById(C3.getClassId());
        Clazz C4 = findClazzById(1);
        Assert.assertNotEquals(C4, null);
    }
}