package DAO;

import MODEL.Student;
import org.hibernate.Session;

import java.util.List;

public class StudentDao {

    public Student createStudent(Student student) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.beginTransaction();
            ss.save(student);
            ss.getTransaction().commit();
            ss.close();
            return student;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateStudent(Student student) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.beginTransaction();
            ss.update(student);
            ss.getTransaction().commit();
            ss.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteStudent(Student student) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.beginTransaction();
            ss.delete(student);
            ss.getTransaction().commit();
            ss.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
