package dao.test;


import Entities.Flow;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static dao.src.FlowDao.findFlowAll;
import static dao.src.FlowDao.findFlowById;

public class FlowDaoTest {

    @Test
    public void testFindFlowAll() {
        List<Flow> L = findFlowAll();
        Assert.assertEquals(6, L.size());
    }

    @Test
    public void testFindFlowById() {
        Flow C = findFlowById(1);
        Assert.assertEquals(C.getFlowId(), 1);
        Flow C2 = findFlowById(100);
        Assert.assertEquals(C2, null);
    }
}