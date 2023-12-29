/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Implementation;

import Dao.SignupDao;
import Model.Signup;
import Service.SignupInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author ericbuturo
 */
public class SignupImpl extends UnicastRemoteObject implements SignupInterface{
    public SignupImpl() throws RemoteException{
        super();
    }
    
    public SignupDao  dao = new SignupDao();

    @Override
    public String registeruser(Signup signup) throws RemoteException {
        return dao.registeruser(signup);
    }

    @Override
    public String updateuser(Signup signup) throws RemoteException {
        return dao.updateuser(signup);
    }

    @Override
    public String deleteuser(Signup signup) throws RemoteException {
        return dao.deleteuser(signup);
    }

    @Override
    public List<Signup> getSignups() throws RemoteException {
        return dao.allSignups();
    }

    @Override
    public List<Signup> retrieveuser(String email, String password) throws RemoteException {
        return dao.retrieveuser(email, password);
    }
    
}
