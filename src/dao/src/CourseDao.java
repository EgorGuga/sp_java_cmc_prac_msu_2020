package dao.src;

import Entities.Course;
import Utils.HibernateFactory;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import javax.persistence.PersistenceException;
import java.util.List;

public class CourseDao {
    private static Session session;

    public static List<Course> findCourseAll() {
        session = HibernateFactory.openSession();
        List<Course> l = session.createCriteria(Course.class).addOrder(Order.asc("year")).addOrder(Order.asc("name")).addOrder(Order.asc("yearOfStudy")).list();
        if (l.size() == 0) return null;
        session.close();
        return l;
    }

    public static Course findCourseById(long id) {
        session = HibernateFactory.openSession();
        Course C = session.get(Course.class, id);
        session.close();
        return C;
    }

    public static void persistCourse(Course C) {
        session = HibernateFactory.openSession();
        session.beginTransaction();
        try {
            session.persist(C);
            session.getTransaction().commit();
        } catch (PersistenceException Exc) {
            session.getTransaction().rollback();
            Exc.printStackTrace();
        }
        session.close();
    }

    public static void updateCourse(Course C) {
        session = HibernateFactory.openSession();
        session.beginTransaction();
        try {
            session.update(C);
            session.getTransaction().commit();
        } catch (PersistenceException Exc) {
            session.getTransaction().rollback();
            Exc.printStackTrace();
        }
        session.close();
    }

    public static void deleteCourseById(long Id) {
        Course C = findCourseById(Id);
        if (C == null) return;
        session = HibernateFactory.openSession();
        session.beginTransaction();
        try {
            session.delete(C);
            session.getTransaction().commit();
        } catch (PersistenceException Exc) {
            session.getTransaction().rollback();
            Exc.printStackTrace();
        }
        session.close();
    }
}