import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;

public class TestClient{
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost",Registry.REGISTRY_PORT);
            IPesawat stubPesawat = (IPesawat) registry.lookup("Pesawat");
            List<Pesawat> listPesawat = (List)stubPesawat.getPesawats();
            System.out.println("~Pesawat~");
            for (Pesawat s:listPesawat) {
                System.out.println("ID: " + s.getId());
                System.out.println("Maskapai: " + s.getMaskapai()); 
                System.out.println("Asal: " + s.getAsal()); 
                System.out.println("Tujuan: " + s.getTujuan()); 
                System.out.println("Tanggal Keberangkatan: " + s.getTanggal()); 
            }
        } catch (Exception e) { 
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

        // try {
        //     Registry registry = LocateRegistry.getRegistry("localhost",Registry.REGISTRY_PORT);
        //     IBioskop stubBioskop = (IBioskop) registry.lookup("Bioskop");
        //     List<Bioskop> listBioskop = (List)stubBioskop.getBioskops();
        //     System.out.println("~Bioskop~");
        //     for (Bioskop b:listBioskop){ 
        //         System.out.println("ID: " + b.getId_film()); 
        //         System.out.println("Film: " + b.getNama_film()); 
        //         System.out.println("Bioskop: " + b.getNama_bioskop()); 
        //         System.out.println("Studio: " + b.getNo_studio()); 
        //     }
        // } catch (Exception e) { 
        //     System.err.println("Client exception: " + e.toString());
        //     e.printStackTrace();
        // }
    }
}