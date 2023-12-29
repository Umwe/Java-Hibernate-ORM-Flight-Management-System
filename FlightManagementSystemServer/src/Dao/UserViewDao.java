/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.UserView;
import java.util.Collections;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ericbuturo
 */
public class UserViewDao {
    public String registeruser(UserView userView){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = ss.beginTransaction();
        ss.save(userView);
        tr.commit();
        ss.close();
        return "Data Saved Successfully";
    }
    
    public String updateuser(UserView userView){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = ss.beginTransaction();
        ss.update(userView);
        tr.commit();
        ss.close();
        return "Data Updated Successfully";
    }
    
    public String deleteuser(UserView userView){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = ss.beginTransaction();
        ss.delete(userView);
        tr.commit();
        ss.close();
        return "Data Deleted Successfully";
    }
    
    public List<UserView> getalluser(){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        List<UserView> userlist = ss.createQuery("Select us from UserView us").list();
        ss.close();
        return userlist;
    }
    
    public List<UserView> retrieveTableData(){
        List<UserView> tableData;
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Query query = ss.createQuery("FROM UserView");
            tableData = query.list();
        } catch (Exception e) {
            e.printStackTrace();
            tableData = Collections.emptyList();
        }
        return tableData;
    }
    
    public UserView catch_userview(UserView userView) {

        Session ss = HibernateUtil.getSessionFactory().openSession();
        UserView pur = (UserView) ss.get(UserView.class, userView.getFlightid());
        ss.close();
        return pur;

    }
}

