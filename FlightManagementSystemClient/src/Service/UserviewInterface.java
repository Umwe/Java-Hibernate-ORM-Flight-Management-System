/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.UserView;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author ericbuturo
 */
public interface UserviewInterface extends Remote{
    public String registeruser(UserView userView) throws RemoteException;
    public String updateuser(UserView userView) throws RemoteException;
    public String deleteuser(UserView userView) throws RemoteException;
    public List<UserView> getUserViews() throws RemoteException;
    public List<UserView> retrieveuser(String email, String password) throws RemoteException;
    public List<UserView> retrieveTableData() throws RemoteException;
    public UserView catch_userview(UserView userView) throws RemoteException; 
}
