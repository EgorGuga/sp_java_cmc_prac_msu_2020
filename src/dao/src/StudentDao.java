package dao.src;

import Entities.Student;
import Utils.HibernateFactory;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import javax.persistence.PersistenceException;
import java.util.List;

public class StudentDao {
    private static Session session;

    public static List<Student> findStudentAll() {
        session = HibernateFactory.openSession();
        List<Student> l = session.createCriteria(Student.class).addOrder(Order.asc("sGroupByGroupId")).addOrder(Order.desc("fullName")).list();
        return l;
    }

    public static Student findStudentById(long id) {
        session = HibernateFactory.openSession();
        Student S = session.get(Student.class, id);
        session.close();
        return S;
    }

    public static List<Student> findStudentByYOS(Integer YOS) {
        session = HibernateFactory.openSession();
        List<Student> l = session.createCriteria(Student.class).add(Restrictions.eq("yearOfStudy", YOS)).addOrder(Order.asc("sGroupByGroupId")).addOrder(Order.desc("fullName")).list();
        if (l.size() == 0) return null;
        session.close();
        return l;
    }

    public static List<Student> findStudentByYOSAndFlow(Integer YOS, int FlowNumber) {
        session = HibernateFactory.openSession();
        List<Student> l = session.createCriteria(Student.class).add(Restrictions.eq("yearOfStudy", YOS)).addOrder(Order.asc("sGroupByGroupId")).addOrder(Order.desc("fullName"))
                .createCriteria("flowByFlowId").add(Restrictions.eq("flowNumber", FlowNumber)).list();
        if (l.size() == 0) return null;
        return l;
    }

    public static List<Student> findStudentByGroup(int GroupNumber) {
        session = HibernateFactory.openSession();
        List<Student> l = session.createCriteria(Student.class).addOrder(Order.desc("fullName"))
                .createCriteria("sGroupByGroupId").add(Restrictions.eq("groupNumber", GroupNumber)).list();
        if (l.size() == 0) return null;
        return l;
    }

    public static void persistStudent(Student S) {
        session = HibernateFactory.openSession();
        session.beginTransaction();
        try {
            session.persist(S);
            session.getTransaction().commit();
        } catch (
        PersistenceException Exc) {
            session.getTransaction().rollback();
            Exc.printStackTrace();
        }
        session.close();
    }

    public static void updateStudent(Student S) {
        session = HibernateFactory.openSession();
        session.beginTransaction();
        try {
            session.update(S);
            session.getTransaction().commit();
        } catch (PersistenceException Exc) {
            session.getTransaction().rollback();
            Exc.printStackTrace();
        }
        session.close();
    }

    public static void deleteStudentById(long Id) {
        Student S = findStudentById(Id);
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







