import java.rmi.Remote; 
import java.rmi.RemoteException; 
import java.util.*;

// Creating Remote interface for our application 
public interface IPesawat extends Remote {  
   public List<Pesawat> getPesawats() throws Exception;  
}