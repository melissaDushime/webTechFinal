package MODEL;


import DAO.HibernateUtil;
import org.hibernate.Session;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bluer
 */
public class Test {
    public static void main(String[] args) {
        Session openSession = HibernateUtil.getSessionFactory().openSession(); 
    }
  
}
