package DAO;

import MODEL.Semester;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import org.hibernate.Query;

public class SemesterDAO {

    public void saveOrUpdateSemester(Semester semester) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(semester); // Use saveOrUpdate instead of save
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Semester getSemesterById(Long semesterId) { // Changed parameter type to Long
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            return (Semester) session.get(Semester.class, semesterId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Semester> getAllSemesters() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query q = session.createQuery("from Semester");
            return q.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteSemester(Long semesterId) { // Changed parameter type to Long
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Semester semester = (Semester) session.get(Semester.class, semesterId);
            if (semester != null) {
                session.delete(semester);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
