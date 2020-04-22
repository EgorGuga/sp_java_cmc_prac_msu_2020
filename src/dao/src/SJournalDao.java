package dao.src;

import Entities.SJournal;
import Utils.HibernateFactory;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import javax.persistence.PersistenceException;
import java.util.List;

public class SJournalDao {
    private static Session session;

    public static List<SJournal> findSJournalAll() {
        session = HibernateFactory.openSession();
        List<SJournal> l = session.createCriteria(SJournal.class).addOrder(Order.asc("classId" )).addOrder(Order.desc("studentId")).list();
        if (l.size() == 0) return null;
        session.close();
        return l;
    }

    public static List<SJournal> findSJournalByStudentId(long id) {
        session = HibernateFactory.openSession();
        List<SJournal> l = session.createCriteria(SJournal.class)
                .add(Restrictions.eq("studentId", id))
                .addOrder(Order.asc("classId")).list();
        if (l.size() == 0) return null;
        session.close();
        return l;
    }

    public static List<SJournal> findSJournalByClassId(long id) {
        session = HibernateFactory.openSession();
        List<SJournal> l = session.createCriteria(SJournal.class)
                .add(Restrictions.eq("classId", id))
                .addOrder(Order.asc("studentId")).list();
        if (l.size() == 0) return null;
        session.close();
        return l;
    }

    public static SJournal findSJournalById(long cid, long sid) {
        session = HibernateFactory.openSession();
        List<SJournal> l = session.createCriteria(SJournal.class)
                .add(Restrictions.eq("classId", cid)).add(Restrictions.eq("studentId", sid))
                .addOrder(Order.asc("studentId")).list();
        if (l.size() == 0) return null;
        session.close();
        return l.get(0);
    }

    public static void persistSJournal(SJournal S) {
        session = HibernateFactory.openSession();
        session.beginTransaction();
        try {
            session.persist(S);
            session.getTransaction().commit();
        } catch (PersistenceException Exc) {
            session.getTransaction().rollback();
            Exc.printStackTrace();
        }
        session.close();
    }

    public static void deleteSJournalById(long cid, long sid) {
        SJournal S = findSJournalById(cid, sid);
        if (S == null) return;
        session = HibernateFactory.openSession();
        session.beginTransaction();
        try {
            session.delete(S);
            session.getTransaction().commit();
        } catch (PersistenceException Exc) {
            session.getTransaction().rollback();
            Exc.printStackTrace();
        }
        session.close();
    }
}
