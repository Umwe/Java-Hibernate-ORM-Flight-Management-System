/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Service.Implementation.AirlineImpl;
import Service.Implementation.DestinationImpl;
import Service.Implementation.SignupImpl;
import Service.Implementation.UserviewImpl;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


/**
 *
 * @author ericbuturo
 */
public class Server{
    public static void main(String [] args){
        try {
            System.setProperty("java.rmi.server.hostname","127.0.0.1");
            Registry registry = LocateRegistry.createRegistry(6000);
            registry.rebind("Signup", new SignupImpl());
            registry.rebind("Userview", new UserviewImpl());
            registry.rebind("Airline", new AirlineImpl());
            registry.rebind("Destination", new DestinationImpl());
            System.out.println("Server is running on port 6000");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
