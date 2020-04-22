package dao.src;

import Entities.Flow;
import Utils.HibernateFactory;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import java.util.List;

public class FlowDao {
    private static Session session;

    public static List<Flow> findFlowAll() {
        session = HibernateFactory.openSession();
        List<Flow> l = session.createCriteria(Flow.class).addOrder(Order.asc("flowId")).list();
        if (l.size() == 0) return null;
        session.close();
        return l;
    }

    public static Flow findFlowById(long id) {
        session = HibernateFactory.openSession();
        Flow F = session.get(Flow.class, id);
        session.close();
        return F;
    }
}







