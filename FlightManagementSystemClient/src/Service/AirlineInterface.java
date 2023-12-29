/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Airline;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author ericbuturo
 */
public interface AirlineInterface extends Remote{
    public String registerairline(Airline airline) throws RemoteException;
    public String updateairline(Airline airline) throws RemoteException;
    public String deleteairline(Airline airline) throws RemoteException;
    public List<Airline> retrieveAirline() throws RemoteException;
}
