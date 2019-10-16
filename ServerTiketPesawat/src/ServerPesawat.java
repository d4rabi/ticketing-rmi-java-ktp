import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry; 
import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject; 

public class ServerPesawat extends PesawatService { 
   public ServerPesawat() {} 
   public static void main(String args[]) { 
      try { 
          Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
          PesawatService obj = new PesawatService();
          
          IPesawat stub = (IPesawat) UnicastRemoteObject.exportObject(obj, 0);
          registry.bind("Pesawat", stub);

         System.err.println("Server ready"); 
      } catch (Exception e) { 
         System.err.println("Server exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}
