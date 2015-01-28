/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver.RmiServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author ruth
 */
public class Client {

    
    private Client() throws RemoteException{}
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        
       try
        {
          Hello hello=(Hello)Naming.lookup("rmi://localhost/Hello");
          System.out.println("looked up registry, message from server: " + hello.sayHello());
        } 
       catch (RemoteException e)
        {
        System.out.println("created registry");
        }
      
       
       
    }

   
    
}
