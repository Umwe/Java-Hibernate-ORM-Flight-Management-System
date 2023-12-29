/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Implementation;

import Dao.AirlineDao;
import Model.Airline;
import Service.AirlineInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author ericbuturo
 */
public class AirlineImpl extends UnicastRemoteObject implements AirlineInterface{

    public AirlineImpl() throws RemoteException{
        super();
    }
    
    public AirlineDao dao = new AirlineDao();
    
    @Override
    public String registerairline(Airline airline) throws RemoteException {
        return dao.registerairline(airline);
    }

    @Override
    public String updateairline(Airline airline) throws RemoteException {
        return dao.updateairline(airline);
    }

    @Override
    public String deleteairline(Airline airline) throws RemoteException {
        return dao.deleteairline(airline);
    }

    @Override
    public List<Airline> retrieveAirline() throws RemoteException {
        return dao.retrieveAirline();
    }
    
}
