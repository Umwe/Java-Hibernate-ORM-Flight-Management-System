/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Implementation;

import Dao.UserViewDao;
import Model.UserView;
import Service.UserviewInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;


/**
 *
 * @author ericbuturo
 */
public class UserviewImpl extends UnicastRemoteObject implements UserviewInterface{
    public UserviewImpl() throws  RemoteException{
        super();
    }
    
    public UserViewDao dao = new UserViewDao();

    @Override
    public String registeruser(UserView userView) throws RemoteException {
        return dao.registeruser(userView);
    }

    @Override
    public String updateuser(UserView userView) throws RemoteException {
        return dao.updateuser(userView);
    }

    @Override
    public String deleteuser(UserView userView) throws RemoteException {
        return dao.deleteuser(userView);
    }

    @Override
    public List<UserView> getUserViews() throws RemoteException {
        return dao.getalluser();
    }

    @Override
    public List<UserView> retrieveTableData() throws RemoteException {
        return dao.retrieveTableData();
    }

    @Override
    public UserView catch_userview(UserView userView) throws RemoteException {
        return dao.catch_userview(userView);
    }

    
    
}
