package dao.src;

import Entities.Professor;
import Utils.HibernateFactory;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import javax.persistence.PersistenceException;
import java.util.List;

public class ProfessorDao {
    private static Session session;

    public static List<Professor> findProfessorAll() {
        session = HibernateFactory.openSession();
        List<Professor> l = session.createCriteria(Professor.class).addOrder(Order.asc("fullName")).list();
        if (l.size() == 0) return null;
        session.close();
        return l;
    }

    public static Professor findProfessorById(long id) {
        session = HibernateFactory.openSession();
        Professor P = session.get(Professor.class, id);
        session.close();
        return P;
    }

    public static List<Professor> findProfessorByName(String Name) {
        session = HibernateFactory.openSession();
        List<Professor> l = session.createCriteria(Professor.class).add(Restrictions.eq("fullName", Name)).list();
        if (l.size() == 0) return null;
        session.close();
        return l;
    }

    public static void persistProfessor(Professor P) {
        session = HibernateFactory.openSession();
        session.beginTransaction();
        try {
            session.persist(P);
            session.getTransaction().commit();
        } catch (PersistenceException Exc) {
            session.getTransaction().rollback();
            Exc.printStackTrace();
        }
        session.close();
    }

    public static void updateProfessor(Professor P) {
        session = HibernateFactory.openSession();
        session.beginTransaction();
        try {
        session.update(P);
        session.getTransaction().commit();
        } catch (PersistenceException Exc) {
            session.getTransaction().rollback();
            Exc.printStackTrace();
        }
        session.close();
    }

    public static void deleteProfessorById(long Id) {
        Professor P = findProfessorById(Id);
        if (P == null) return;
        session = HibernateFactory.openSession();
        session.beginTransaction();
        try {
        session.delete(P);
        session.getTransaction().commit();
        } catch (PersistenceException Exc) {
            session.getTransaction().rollback();
            Exc.printStackTrace();
        }
        session.close();
    }
}
