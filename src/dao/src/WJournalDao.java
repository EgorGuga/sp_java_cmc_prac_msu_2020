package dao.src;

import Entities.WJournal;
import Utils.HibernateFactory;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import javax.persistence.PersistenceException;
import java.util.List;

public class WJournalDao {
    private static Session session;

    public static List<WJournal> findWJournalAll() {
        session = HibernateFactory.openSession();
        List<WJournal> l = session.createCriteria(WJournal.class).addOrder(Order.asc("courseId")).addOrder(Order.desc("professorId")).list();
        if (l.size() == 0) return null;
        session.close();
        return l;
    }
    public static List<WJournal> findWJournalByProfessorId(long id) {
        session = HibernateFactory.openSession();
        List<WJournal> l = session.createCriteria(WJournal.class)
                .add(Restrictions.eq("professorId", id))
                .addOrder(Order.asc("courseId")).list();
        if (l.size() == 0) return null;
        session.close();
        return l;
    }

    public static List<WJournal> findWJournalByCourseId(long id) {
        session = HibernateFactory.openSession();
        List<WJournal> l = session.createCriteria(WJournal.class)
                .add(Restrictions.eq("courseId", id))
                .addOrder(Order.asc("professorId")).list();
        if (l.size() == 0) return null;
        session.close();
        return l;
    }

    public static WJournal findWJournalById(long cid, long pid) {
        session = HibernateFactory.openSession();
        List<WJournal> l = session.createCriteria(WJournal.class)
                .add(Restrictions.eq("courseId", cid)).add(Restrictions.eq("professorId", pid))
                .addOrder(Order.asc("professorId")).list();
        if (l.size() == 0) return null;
        session.close();
        return l.get(0);
    }

    public static void persistWJournal(WJournal W) {
        session = HibernateFactory.openSession();
        session.beginTransaction();
        try {
            session.persist(W);
            session.getTransaction().commit();
        } catch (PersistenceException Exc) {
            session.getTransaction().rollback();
            Exc.printStackTrace();
        }
        session.close();
    }

    public static void deleteWJournalById(long cid, long pid) {
        WJournal W = findWJournalById(cid, pid);
        if (W == null) return;
        session = HibernateFactory.openSession();
        session.beginTransaction();
        try {
            session.delete(W);
            session.getTransaction().commit();
        } catch (PersistenceException Exc) {
            session.getTransaction().rollback();
            Exc.printStackTrace();
        }
        session.close();
    }
}
