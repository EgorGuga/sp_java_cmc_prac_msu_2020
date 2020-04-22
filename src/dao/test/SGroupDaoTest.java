package dao.test;

import Entities.SGroup;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static dao.src.SGroupDao.findSGroupAll;
import static dao.src.SGroupDao.findSGroupById;

public class SGroupDaoTest {

    @Test
    public void testFindSGroupAll() {
        List<SGroup> L = findSGroupAll();
        Assert.assertEquals(12, L.size());
    }

    @Test
    public void testFindSGroupById() {
        SGroup C = findSGroupById(1);
        Assert.assertEquals(C.getGroupId(), 1);
        SGroup C2 = findSGroupById(100);
        Assert.assertEquals(C2, null);
    }
}