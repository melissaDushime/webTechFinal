package DAO;

import DAO.HibernateUtil;
import java.util.List;
import MODEL.Userr;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Transaction;

public class UserzDao {
    
    public Userr createUser(Userr user){
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.save(user);
            ss.beginTransaction().commit();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Userr updateUser(Userr user) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.update(user);
            ss.beginTransaction().commit();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Userr deleteUser(Userr user) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            ss.delete(user);
            ss.beginTransaction().commit();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Userr findUserById(Userr user) {
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Userr theUser = (Userr) ss.get(Userr.class, user.getId());
            return theUser;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Userr> getAllUsers() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<Userr> users = session.createQuery("FROM Userr").list();
            session.close();
            return users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Userr findByEmail(String email) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Userr.class);
            criteria.add(Restrictions.eq("email", email));
            Userr foundUser = (Userr) criteria.uniqueResult();
            session.close();
            return foundUser;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
