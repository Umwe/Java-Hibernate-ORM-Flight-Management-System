/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Signup;
import Model.UserView;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ericbuturo
 */
public class SignupDao {
    public String registeruser(Signup signup){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = ss.beginTransaction();
        ss.save(signup);
        tr.commit();
        ss.close();
        return "Data Signup Successfully";
    }
    
    public String updateuser(Signup signup){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = ss.beginTransaction();
        ss.update(signup);
        tr.commit();
        ss.close();
        return "Data Updated Successfully";
    }
    
    public String deleteuser(Signup signup){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = ss.beginTransaction();
        ss.delete(signup);
        tr.commit();
        ss.close();
        return "Data Deleted Successfully";
    }
    
    public List<Signup> allSignups(){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        List<Signup> userList = ss.createQuery("Select sn from signup sn").list();
        ss.close();
        return userList;
    }
    
    public List<Signup> retrieveUser() {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        List<Signup> userList = ss.createQuery("Select sn from signup sn").list();
        ss.close();
        return userList;
    }
    
    public List<Signup> retrieveuser(String email, String password){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        List<Signup> userlist = null;
        try {
            Query query = ss.createQuery("select users from Signup users where users.email = :email and users.password = :password");
            query.setParameter("email", email);
            query.setParameter("password", password);
            
            userlist = query.list();
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            
            ss.close();
        
        }
        
        return userlist;
    }
}
