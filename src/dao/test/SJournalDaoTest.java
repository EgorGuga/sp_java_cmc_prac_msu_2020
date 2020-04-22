package dao.test;

import Entities.SJournal;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static dao.src.ClazzDao.findClazzById;
import static dao.src.SJournalDao.*;
import static dao.src.StudentDao.findStudentById;

public class SJournalDaoTest {

    @Test
    public void testFindSJournalAll() {
        List<SJournal> L = findSJournalAll();
        Assert.assertEquals(42, L.size());
    }

    @Test
    public void testFindSJournalByStudentId() {
        List<SJournal> L = findSJournalByStudentId(1);
        Set<Long> S = new HashSet<Long>();
        for(SJournal b : L)
            S.add(b.getClassId());
        Set<Long> S2 = new HashSet<Long>();
        S2.add((long) 1); S2.add((long) 2); S2.add((long) 9);
        Assert.assertEquals(S2, S);

        List<SJournal> L2 = findSJournalByStudentId(100);
        Assert.assertEquals(L2, null);
    }

    @Test
    public void testFindSJournalByClassId() {
        List<SJournal> L = findSJournalByClassId(1);
        Set<Long> S = new HashSet<Long>();
        for(SJournal b : L)
            S.add(b.getStudentId());
        Set<Long> S2 = new HashSet<Long>();
        S2.add((long) 1); S2.add((long) 2); S2.add((long) 3); S2.add((long) 4); S2.add((long) 5); S2.add((long) 6);
        Assert.assertEquals(S2, S);

        List<SJournal> L2 = findSJournalByClassId(100);
        Assert.assertEquals(L2, null);
    }

    @Test
    public void testFindSJournalById() {
        SJournal SJ = findSJournalById(1, 1);
        Assert.assertEquals(SJ.getClassId(), 1);
        Assert.assertEquals(SJ.getStudentId(), 1);

        SJournal SJ2 = findSJournalById(100, 1);
        Assert.assertEquals(SJ2, null);

        SJournal SJ3 = findSJournalById(1, 100);
        Assert.assertEquals(SJ3, null);

        SJournal SJ4 = findSJournalById(100, 100);
        Assert.assertEquals(SJ4, null);
    }

    @Test(dependsOnMethods = {"testFindSJournalAll"})
    public void testPersistSJournal() {
        SJournal C = new SJournal(); C.setStudentByStudentId(findStudentById(15)); C.setStudentId(15); C.setClassByClassId(findClazzById(9)); C.setClassId(9);
        persistSJournal(C);
        SJournal C2 = findSJournalById(9, 15);
        Assert.assertNotEquals(C2, null);
    }

    @Test(dependsOnMethods = {"testPersistSJournal"})
    public void testDeleteSJournalById() {
        SJournal C = findSJournalById(9, 15);
        deleteSJournalById(C.getClassId(), C.getStudentId());
        SJournal C2 = findSJournalById(9, 15);
        Assert.assertEquals(C2, null);
    }
}