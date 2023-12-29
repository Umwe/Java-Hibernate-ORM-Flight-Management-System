/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Destination;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author ericbuturo
 */
public interface DestinationInterface extends Remote{
    public String registerdestination(Destination destination) throws RemoteException;
    public String updatedestination(Destination destination) throws RemoteException;
    public String deletedestination(Destination destination) throws RemoteException;
    public List<Destination> retrieveDestination() throws RemoteException;
    
}
