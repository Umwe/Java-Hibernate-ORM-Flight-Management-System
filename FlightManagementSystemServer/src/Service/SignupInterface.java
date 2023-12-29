/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Signup;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


/**
 *
 * @author ericbuturo
 */
public interface SignupInterface extends Remote{
    public String registeruser(Signup signup) throws RemoteException;
    public String updateuser (Signup signup) throws RemoteException;
    public String deleteuser (Signup signup) throws RemoteException;
    public List<Signup> getSignups() throws RemoteException;
    public List<Signup> retrieveuser(String email, String password) throws RemoteException;
}
