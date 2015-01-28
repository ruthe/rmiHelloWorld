/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver.RmiServer;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author ruth
 */
public interface Hello extends Remote{
    
    /**
     *
     * @return
     * @throws RemoteException
     */
    String sayHello() throws RemoteException;

    //public String sayHello(Object object);
}
