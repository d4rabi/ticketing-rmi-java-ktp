/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Annisa
 */

import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry; 
import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject; 

public class ServerBioskop extends BioskopService {
    public ServerBioskop(){}
    
    public static void main(String[] args) {
        try { 
          Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
          BioskopService obj = new BioskopService();
          
          IBioskop stub = (IBioskop) UnicastRemoteObject.exportObject(obj, 0);
          registry.bind("Bioskop", stub);
          
        System.err.println("Server ready"); 
        } catch (Exception e) { 
         System.err.println("Server exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}
    
