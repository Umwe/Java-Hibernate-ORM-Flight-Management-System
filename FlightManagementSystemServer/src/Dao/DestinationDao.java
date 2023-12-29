/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Destination;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ericbuturo
 */
public class DestinationDao {
    public String registerdestination(Destination destination){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = ss.beginTransaction();
        ss.save(destination);
        tr.commit();
        ss.close();
        return "Data Saved Successfully";
    }
    
    public String updatedestination(Destination destination){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = ss.beginTransaction();
        ss.update(destination);
        tr.commit();
        ss.close();
        return "Data Updated Successfully";
    }
    
    public String deleteairline(Destination destination){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = ss.beginTransaction();
        ss.delete(destination);
        tr.commit();
        ss.close();
        return "Data deleted Successfully";
    }
    
    public List<Destination> retrieveDestination() {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        List<Destination> userList = ss.createQuery("Select dn from Destination dn").list();
        ss.close();
        return userList;
    }
}