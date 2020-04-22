package dao.test;

import Entities.LectureHall;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static dao.src.LectureHallDao.*;

public class LectureHallDaoTest {

    @Test
    public void testFindLectureHallAll() {
        List<LectureHall> L = findLectureHallAll();
        Assert.assertEquals(10, L.size());
    }

    @Test
    public void testFindLectureHallById() {
        LectureHall LH = findLectureHallById(1);
        Assert.assertEquals(LH.getLectureHallId(), 1);
        LectureHall LH2 = findLectureHallById(100);
        Assert.assertEquals(LH2, null);
    }

    @Test
    public void testFindLectureHallByNumber() {
        List<LectureHall> L = findLectureHallByNumber("П-2");
        Set<Long> S = new HashSet<Long>();
        for(LectureHall b : L)
            S.add(b.getLectureHallId());
        Set<Long> S2 = new HashSet<Long>();
        S2.add((long) 2);
        Assert.assertEquals(S2, S);

        List<LectureHall> L2 = findLectureHallByNumber("Абракадабра");
        Assert.assertEquals(L2, null);
    }

    @Test(dependsOnMethods = {"testFindLectureHallAll"})
    public void testPersistLectureHall() {
        LectureHall C = new LectureHall(); C.setLectureHallId(11); C.setCapacity(20); C.setNumber("П-20");
        persistLectureHall(C);
        LectureHall C2 = findLectureHallById(11);
        Assert.assertNotEquals(C2, null);

        LectureHall C3 = new LectureHall(); C3.setLectureHallId(12); C3.setCapacity(-20); C3.setNumber("П-20");
        persistLectureHall(C3);
        LectureHall C4 = findLectureHallById(12);
        Assert.assertEquals(C4, null);
    }

    @Test(dependsOnMethods = {"testPersistLectureHall"})
    public void testUpdateLectureHall() {
        LectureHall C = findLectureHallById(11);
        C.setNumber("П-21");
        updateLectureHall(C);
        LectureHall C2 = findLectureHallById(11);
        Assert.assertEquals(C2.getNumber(), "П-21");

        LectureHall C3 = findLectureHallById(11);
        C3.setNumber("П-2123456789123456789");
        updateLectureHall(C);
        LectureHall C4 = findLectureHallById(11);
        Assert.assertEquals(C4.getNumber(), "П-21");
    }

    @Test(dependsOnMethods = {"testUpdateLectureHall"})
    public void testDeleteLectureHallById() {
        LectureHall C = findLectureHallById(11);
        deleteLectureHallById(C.getLectureHallId());
        LectureHall C2 = findLectureHallById(11);
        Assert.assertEquals(C2, null);

        LectureHall C3 = findLectureHallById(1);
        deleteLectureHallById(C3.getLectureHallId());
        LectureHall C4 = findLectureHallById(1);
        Assert.assertNotEquals(C4, null);
    }
}