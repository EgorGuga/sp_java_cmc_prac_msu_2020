package dao.src;

import Entities.LectureHall;
import Utils.HibernateFactory;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import javax.persistence.PersistenceException;
import java.util.List;

public class LectureHallDao {
    private static Session session;

    public static List<LectureHall> findLectureHallAll() {
        session = HibernateFactory.openSession();
        List<LectureHall> l = session.createCriteria(LectureHall.class).addOrder(Order.asc("number")).list();
        if (l.size() == 0) return null;
        session.close();
        return l;
    }

    public static LectureHall findLectureHallById(long id) {
        session = HibernateFactory.openSession();
        LectureHall LH = session.get(LectureHall.class, id);
        session.close();
        return LH;
    }

    public static List<LectureHall> findLectureHallByNumber(String Number) {
        session = HibernateFactory.openSession();
        List<LectureHall> l = session.createCriteria(LectureHall.class).add(Restrictions.eq("number", Number)).list();
        if (l.size() == 0) return null;
        session.close();
        return l;
    }

    public static void persistLectureHall(LectureHall LH) {
        session = HibernateFactory.openSession();
        session.beginTransaction();
        try {
            session.persist(LH);
            session.getTransaction().commit();
        } catch (PersistenceException Exc) {
            session.getTransaction().rollback();
            Exc.printStackTrace();
        }
        session.close();
    }

    public static void updateLectureHall(LectureHall LH) {
        session = HibernateFactory.openSession();
        session.beginTransaction();
        try {
            session.update(LH);
            session.getTransaction().commit();
        } catch (PersistenceException Exc) {
            session.getTransaction().rollback();
            Exc.printStackTrace();
        }
        session.close();
    }

    public static void deleteLectureHallById(long Id) {
        LectureHall LH = findLectureHallById(Id);
        if (LH == null) return;
        session = HibernateFactory.openSession();
        session.beginTransaction();
        try {
        session.delete(LH);
        session.getTransaction().commit();
        } catch (PersistenceException Exc) {
            session.getTransaction().rollback();
            Exc.printStackTrace();
        }
        session.close();
    }
}
