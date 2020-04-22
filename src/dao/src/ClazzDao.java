package dao.src;

import Entities.Clazz;
import Utils.HibernateFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import javax.persistence.PersistenceException;
import java.util.List;

public class ClazzDao {
    private static Session session;

    public static List<Clazz> findClazzAll() {
        session = HibernateFactory.openSession();
        List<Clazz> l = session.createCriteria(Clazz.class).addOrder(Order.asc("classId")).list();
        if (l.size() == 0) return null;
        session.close();
        return l;
    }

    public static Clazz findClazzById(long id) {
        session = HibernateFactory.openSession();
        Clazz C = session.get(Clazz.class, id);
        session.close();
        return C;
    }

    public static List<Clazz> findClazzByStudent(long id) {
        session = HibernateFactory.openSession();
        List<Clazz> l = session.createCriteria(Clazz.class)
                .createCriteria("sJournalsByClassId").add(Restrictions.eq("studentId", id))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        List<Clazz> l2 = session.createCriteria(Clazz.class)
                .addOrder(Order.asc("dayOfTheWeek")).addOrder(Order.asc("startTime"))
                .createCriteria("courseByCourseId")
                .add(Restrictions.eq("active", (byte)1))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
        l.retainAll(l2);
        if (l.size() == 0) return null;
        session.close();
        return l;
    }

    public static List<Clazz> findClazzByCourse(long id) {
        session = HibernateFactory.openSession();
        List<Clazz> l = session.createCriteria(Clazz.class).addOrder(Order.asc("dayOfTheWeek")).addOrder(Order.asc("startTime"))
                .createCriteria("courseByCourseId").add(Restrictions.eq("active", (byte)1)).add(Restrictions.eq("courseId", id))
                .list();
        if (l.size() == 0) return null;
        session.close();
        return l;
    }

    public static List<Clazz> findClazzByLectureHall(long id) {
        session = HibernateFactory.openSession();
        List<Clazz> l = session.createCriteria(Clazz.class)
                .createCriteria("lectureHallByLectureHallId").add(Restrictions.eq("lectureHallId", id))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        List<Clazz> l2 = session.createCriteria(Clazz.class)
                .addOrder(Order.asc("dayOfTheWeek")).addOrder(Order.asc("startTime"))
                .createCriteria("courseByCourseId").add(Restrictions.eq("active", (byte)1))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
        l.retainAll(l2);
        if (l.size() == 0) return null;
        session.close();
        return l;
    }

    public static List<Clazz> findClazzByProfessor(long id) {
        session = HibernateFactory.openSession();
        List<Clazz> l = session.createCriteria(Clazz.class)
                .createCriteria("professorByProfessorId").add(Restrictions.eq("professorId", id))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        List<Clazz> l2 = session.createCriteria(Clazz.class)
                .addOrder(Order.asc("dayOfTheWeek")).addOrder(Order.asc("startTime"))
                .createCriteria("courseByCourseId").add(Restrictions.eq("active", (byte)1))
                .add(Restrictions.ne("coverage", "спец. курс")).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
        l.retainAll(l2);
        if (l.size() == 0) return null;
        session.close();
        return l;
    }

    public static List<Clazz> findClazzByYOS(int YOS) {
        session = HibernateFactory.openSession();
        List<Clazz> l = session.createCriteria(Clazz.class)
                .createCriteria("sJournalsByClassId").createCriteria("studentByStudentId")
                .add(Restrictions.eq("yearOfStudy", YOS)).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        List<Clazz> l2 = session.createCriteria(Clazz.class)
                .addOrder(Order.asc("dayOfTheWeek")).addOrder(Order.asc("startTime"))
                .createCriteria("courseByCourseId").add(Restrictions.eq("active", (byte)1))
                .add(Restrictions.ne("coverage", "спец. курс")).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
        l.retainAll(l2);
        if (l.size() == 0) return null;
        session.close();
        return l;
    }

    public static List<Clazz> findClazzByGroup(int GroupNumber) {
        session = HibernateFactory.openSession();
        List<Clazz> l = session.createCriteria(Clazz.class)
                .createCriteria("sJournalsByClassId").createCriteria("studentByStudentId").createCriteria("sGroupByGroupId")
                .add(Restrictions.eq("groupNumber", GroupNumber)).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        List<Clazz> l2 = session.createCriteria(Clazz.class)
                .addOrder(Order.asc("dayOfTheWeek")).addOrder(Order.asc("startTime"))
                .createCriteria("courseByCourseId").add(Restrictions.eq("active", (byte)1)).add(Restrictions.ne("coverage", "спец. курс"))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
        l.retainAll(l2);
        if (l.size() == 0) return null;
        session.close();
        return l;
    }

    public static List<Clazz> findClazzByFlow(int FlowNumber) {
        session = HibernateFactory.openSession();
        List<Clazz> l = session.createCriteria(Clazz.class)
                .createCriteria("sJournalsByClassId").createCriteria("studentByStudentId").createCriteria("flowByFlowId")
                .add(Restrictions.eq("flowNumber", FlowNumber)).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        List<Clazz> l2 = session.createCriteria(Clazz.class)
                .addOrder(Order.asc("dayOfTheWeek")).addOrder(Order.asc("startTime"))
                .createCriteria("courseByCourseId")
                .add(Restrictions.eq("active", (byte)1)).add(Restrictions.ne("coverage", "спец. курс")).add(Restrictions.ne("coverage", "группа"))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
        l.retainAll(l2);
        if (l.size() == 0) return null;
        session.close();
        return l;
    }

    public static void persistClazz(Clazz C) {
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

    public static void updateClazz(Clazz C) {
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

    public static void deleteClazzById(long Id) {
        Clazz C = findClazzById(Id);
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
