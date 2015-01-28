/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver.RmiServer;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author ruth
 */
public class Server extends UnicastRemoteObject implements Hello {

    public Server() throws RemoteException{
    }

    @Override
    public String sayHello() throws RemoteException {

        return "Hello world!";
    }

    public static void main(String[] args) throws RemoteException {

        /**
         * try { Server obj = new Server(); Hello stub = (Hello)
         * UnicastRemoteObject.exportObject(obj, 0);
         *
         * // Bind the remote object's stub in the registry Registry registry =
         * LocateRegistry.getRegistry(); registry.bind("Hello", stub);
         *
         * System.err.println("Server ready"); } catch (Exception e) {
         * System.err.println("Server exception: " + e.toString());
         * e.printStackTrace(); }*
         */
        try {
            LocateRegistry.getRegistry(1099).list();
            System.out.println("got registry");
        } catch (RemoteException e) {
            LocateRegistry.createRegistry(1099);
            System.out.println("created registry");
        }
        try {
            Server server = new Server();
            System.out.println("try to rebound registry");
            Naming.rebind("rmi://localhost/Hello", server);
            System.out.println("rebound registry");
        } catch (Exception e) {
            System.out.println("rebind not working: " + e);
        }
    }

    

}
