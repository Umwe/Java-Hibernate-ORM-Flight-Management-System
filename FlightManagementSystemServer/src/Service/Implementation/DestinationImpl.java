/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Implementation;

import Dao.DestinationDao;
import Model.Destination;
import Service.DestinationInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author ericbuturo
 */
public class DestinationImpl extends UnicastRemoteObject implements DestinationInterface{

    public DestinationImpl() throws RemoteException{
    }
    
    public DestinationDao dao = new DestinationDao();
    
    @Override
    public String registerdestination(Destination destination) throws RemoteException {
        return dao.registerdestination(destination);
    }

    @Override
    public String updatedestination(Destination destination) throws RemoteException {
        return dao.updatedestination(destination);
    }

    @Override
    public String deletedestination(Destination destination) throws RemoteException {
        return dao.deleteairline(destination);
    }


    @Override
    public List<Destination> retrieveDestination() throws RemoteException {
        return dao.retrieveDestination();
    }
    
}
