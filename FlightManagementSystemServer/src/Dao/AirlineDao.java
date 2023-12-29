/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Airline;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ericbuturo
 */
public class AirlineDao {
    public String registerairline(Airline airline){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = ss.beginTransaction();
        ss.save(airline);
        tr.commit();
        ss.close();
        return "Data Saved Successfully";
    }
    
    public String updateairline(Airline airline){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = ss.beginTransaction();
        ss.update(airline);
        tr.commit();
        ss.close();
        return "Data Updated Successfully";
    }
    
    public String deleteairline(Airline airline){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = ss.beginTransaction();
        ss.delete(airline);
        tr.commit();
        ss.close();
        return "Data deleted Successfully";
    }
    
    public List<Airline> retrieveAirline() {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        List<Airline> userList = ss.createQuery("Select an from Airline an").list();
        ss.close();
        return userList;
    }
}
