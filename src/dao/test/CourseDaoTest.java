package dao.test;

import Entities.Course;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static dao.src.CourseDao.*;

public class CourseDaoTest {

    @Test
    public void testFindCourseAll() {
        List<Course> L = findCourseAll();
        Assert.assertEquals(5, L.size());
    }

    @Test
    public void testFindCourseById() {
        Course C = findCourseById(1);
        Assert.assertEquals(C.getCourseId(), 1);
        Course C2 = findCourseById(100);
        Assert.assertEquals(C2, null);
    }

    @Test(dependsOnMethods = {"testFindCourseAll"})
    public void testPersistCourse() {
        Course C = new Course(); C.setCourseId(6); C.setName("Дискретная математика");
        C.setCoverage("Поток"); C.setIntensity(1); C.setYearOfStudy(1);
        C.setYear(2020); C.setActive((byte)1);
        persistCourse(C);
        Course C2 = findCourseById(6);
        Assert.assertNotEquals(C2, null);

        Course C3 = new Course(); C3.setCourseId(7); C3.setName("Дискретная нематематика");
        C3.setCoverage("Поток"); C3.setIntensity(100); C3.setYearOfStudy(-1);
        C3.setYear(2020); C3.setActive((byte)1);
        persistCourse(C3);
        Course C4 = findCourseById(7);
        Assert.assertEquals(C4, null);
    }

    @Test(dependsOnMethods = {"testPersistCourse"})
    public void testUpdateCourse() {
        Course C = findCourseById(6);
        C.setIntensity(2);
        updateCourse(C);
        Course C2 = findCourseById(6);
        Assert.assertEquals(C2.getIntensity(), (Integer)2);

        Course C3 = findCourseById(6);
        C3.setIntensity(-3);
        updateCourse(C);
        Course C4 = findCourseById(6);
        Assert.assertEquals(C4.getIntensity(), (Integer)2);
    }

    @Test(dependsOnMethods = {"testUpdateCourse"})
    public void testDeleteCourseById() {
        Course C = findCourseById(6);
        deleteCourseById(C.getCourseId());
        Course C2 = findCourseById(6);
        Assert.assertEquals(C2, null);

        Course C3 = findCourseById(1);
        deleteCourseById(C3.getCourseId());
        Course C4 = findCourseById(1);
        Assert.assertNotEquals(C4, null);
    }
}