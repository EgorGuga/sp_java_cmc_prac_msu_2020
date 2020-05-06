package dao.src;

import Entities.SGroup;
import Utils.HibernateFactory;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import java.util.List;

public class SGroupDao {
    private static Session session;

    public static List<SGroup> findSGroupAll() {
        session = HibernateFactory.openSession();
        List<SGroup> l = session.createCriteria(SGroup.class).addOrder(Order.asc("groupNumber")).list();
        if (l.size() == 0) return null;
        session.close();
        return l;
    }

    public static SGroup findSGroupById(long id) {
        session = HibernateFactory.openSession();
        SGroup SG = session.get(SGroup.class, id);
        return SG;
    }
}