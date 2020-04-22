package dao.test;

import Entities.WJournal;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static dao.src.CourseDao.findCourseById;
import static dao.src.ProfessorDao.findProfessorById;
import static dao.src.WJournalDao.*;

public class WJournalDaoTest {

    @Test
    public void testFindWJournalAll() {
        List<WJournal> L = findWJournalAll();
        Assert.assertEquals(4, L.size());
    }

    @Test
    public void testFindWJournalByProfessorId() {
        List<WJournal> L = findWJournalByProfessorId(1);
        Set<Long> S = new HashSet<Long>();
        for(WJournal b : L)
            S.add(b.getCourseId());
        Set<Long> S2 = new HashSet<Long>();
        S2.add((long) 1);
        Assert.assertEquals(S2, S);

        List<WJournal> L2 = findWJournalByProfessorId(100);
        Assert.assertEquals(L2, null);
    }

    @Test
    public void testFindWJournalByCourseId() {
        List<WJournal> L = findWJournalByCourseId(1);
        Set<Long> S = new HashSet<Long>();
        for(WJournal b : L)
            S.add(b.getProfessorId());
        Set<Long> S2 = new HashSet<Long>();
        S2.add((long) 1);
        Assert.assertEquals(S2, S);

        List<WJournal> L2 = findWJournalByProfessorId(100);
        Assert.assertEquals(L2, null);
    }

    @Test
    public void testFindWJournalById() {
        WJournal WJ = findWJournalById(1, 1);
        Assert.assertEquals(WJ.getCourseId(), 1);
        Assert.assertEquals(WJ.getProfessorId(), 1);

        WJournal WJ2 = findWJournalById(100, 1);
        Assert.assertEquals(WJ2, null);

        WJournal WJ3 = findWJournalById(1, 100);
        Assert.assertEquals(WJ3, null);

        WJournal WJ4 = findWJournalById(100, 100);
        Assert.assertEquals(WJ4, null);
    }

    @Test(dependsOnMethods = {"testFindWJournalAll"})
    public void testPersistWJournal() {
        WJournal C = new WJournal(); C.setCourseByCourseId(findCourseById(1)); C.setCourseId(1); C.setProfessorByProfessorId(findProfessorById(2)); C.setProfessorId(2);
        persistWJournal(C);
        WJournal C2 = findWJournalById(1, 2);
        Assert.assertNotEquals(C2, null);
    }

    @Test(dependsOnMethods = {"testPersistWJournal"})
    public void testDeleteWJournalById() {
        WJournal C = findWJournalById(1, 2);
        deleteWJournalById(C.getCourseId(), C.getProfessorId());
        WJournal C2 = findWJournalById(1, 2);
        Assert.assertEquals(C2, null);
    }
}