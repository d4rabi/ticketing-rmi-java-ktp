

import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry; 
import java.util.*;  

public class ClientBioskop {

    private ClientBioskop(){}
    
    public static void main(String[] args) {
       try { 
         // Getting the registry 
         Registry registry = LocateRegistry.getRegistry("localhost",Registry.REGISTRY_PORT); 
    
         // Looking up the registry for the remote object 
         IBioskop stub = (IBioskop) registry.lookup("Hello"); 
    
         // Calling the remote method using the obtained object 
         List<Bioskop> list = (List)stub.getBioskops(); 
         for (Bioskop b:list){ 
            
            // System.out.println("bc "+s.getBranch()); 
            System.out.println("ID: " + b.getId_film()); 
            System.out.println("name: " + b.getNama_film()); 
            System.out.println("branch: " + b.getNama_bioskop()); 
            System.out.println("percent: " + b.getNo_studio()); 
//            System.out.println("email: " + b.getEmail()); 
         }  
      // System.out.println(list); 
      } catch (Exception e) { 
         System.err.println("Client exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
    }
}

