import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry; 
import java.util.*;  

public class ClientPesawat {  
   private ClientPesawat() {}  
   public static void main(String[] args)throws Exception {  
      try { 
         // Getting the registry 
         Registry registry = LocateRegistry.getRegistry("localhost",Registry.REGISTRY_PORT); 
    
         // Looking up the registry for the remote object 
         HelloPesawat stub = (HelloPesawat) registry.lookup("Hello"); 
    
         // Calling the remote method using the obtained object 
         List<Pesawat> list = (List)stub.getPesawats(); 
         for (Pesawat s:list) { 
            
            // System.out.println("bc "+s.getBranch()); 
            System.out.println("ID: " + s.getId()); 
            System.out.println("name: " + s.getMaskapai()); 
            System.out.println("branch: " + s.getAsal()); 
            System.out.println("percent: " + s.getTujuan()); 
            System.out.println("email: " + s.getTanggal()); 
         }  
      // System.out.println(list); 
      } catch (Exception e) { 
         System.err.println("Client exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}