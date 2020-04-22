package dao.test;

import Entities.Professor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static dao.src.LectureHallDao.deleteLectureHallById;
import static dao.src.ProfessorDao.*;

public class ProfessorDaoTest {

    @Test
    public void testFindProfessorAll() {
        List<Professor> L = findProfessorAll();
        Assert.assertEquals(5, L.size());
    }

    @Test
    public void testFindProfessorById() {
        Professor P = findProfessorById(1);
        Assert.assertEquals(P.getProfessorId(), 1);
        Professor P2 = findProfessorById(100);
        Assert.assertEquals(P2, null);
    }

    @Test
    public void testFindProfessorByName() {
        List<Professor> L = findProfessorByName("Лобанов Пётр Евгеньевич");
        Set<Long> S = new HashSet<Long>();
        for(Professor b : L)
            S.add(b.getProfessorId());
        Set<Long> S2 = new HashSet<Long>();
        S2.add((long) 2);
        Assert.assertEquals(S2, S);

        List<Professor> L2 = findProfessorByName("Абракадабра");
        Assert.assertEquals(L2, null);
    }

    @Test(dependsOnMethods = {"testFindProfessorAll"})
    public void testPersistProfessor() {
        Professor C = new Professor(); C.setProfessorId(6); C.setFullName("Сысоев Борис Иванович");
        persistProfessor(C);
        Professor C2 = findProfessorById(6);
        Assert.assertNotEquals(C2, null);

        Professor C3 = new Professor(); C3.setProfessorId(7);
        persistProfessor(C3);
        Professor C4 = findProfessorById(7);
        Assert.assertEquals(C4, null);
    }

    @Test(dependsOnMethods = {"testPersistProfessor"})
    public void testUpdateProfessor() {
        Professor C = findProfessorById(6);
        C.setFullName("Сысоев Борис Владимирович");
        updateProfessor(C);
        Professor C2 = findProfessorById(6);
        Assert.assertEquals(C2.getFullName(), "Сысоев Борис Владимирович");

        Professor C3 = findProfessorById(6);
        C3.setFullName("Сысоев Борис Владимирович 1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
        updateProfessor(C);
        Professor C4 = findProfessorById(6);
        Assert.assertEquals(C4.getFullName(), "Сысоев Борис Владимирович");
    }

    @Test(dependsOnMethods = {"testUpdateProfessor"})
    public void testDeleteProfessorById() {
        Professor C = findProfessorById(6);
        deleteProfessorById(C.getProfessorId());
        Professor C2 = findProfessorById(6);
        Assert.assertEquals(C2, null);

        Professor C3 = findProfessorById(1);
        deleteLectureHallById(C3.getProfessorId());
        Professor C4 = findProfessorById(1);
        Assert.assertNotEquals(C4, null);
    }
}