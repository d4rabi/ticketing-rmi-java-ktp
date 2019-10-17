import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;
import java.lang.reflect.Field;

public class TestClient{
    private static void forceRegistryHostNameOnStub(Object registry, Object stub) {
        try {
            String regHost = getReferenceToInnerObject(registry, "ref", "ref", "ep", "host").toString();
    
            Object stubEp = getReferenceToInnerObject(stub, "h", "ref", "ref", "ep");
            Field fStubHost = getInheritedPrivateField(stubEp, "host");
            fStubHost.setAccessible(true);
            fStubHost.set(stubEp, regHost);
        } catch (Exception e) {
            
        }
    }
    
    private static Object getReferenceToInnerObject(Object from, String... objectHierarchy) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Object ref = from;
        for (String fieldname : objectHierarchy) {
            Field f = getInheritedPrivateField(ref, fieldname);
            f.setAccessible(true);
            ref = f.get(ref);
        }
        return ref;
    }
    
    private static Field getInheritedPrivateField(Object from, String fieldname) throws NoSuchFieldException {
        Class<?> i = from.getClass();
        while (i != null && i != Object.class) {
            try {
                return i.getDeclaredField(fieldname);
            } catch (NoSuchFieldException e) {
                
            }
            i = i.getSuperclass();
        }
        return from.getClass().getDeclaredField(fieldname);
    }
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("192.168.137.187",Registry.REGISTRY_PORT);
            IPesawat stubPesawat = (IPesawat) registry.lookup("Pesawat");
            forceRegistryHostNameOnStub(registry, stubPesawat);
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

        try {
            Registry registry = LocateRegistry.getRegistry("localhost",Registry.REGISTRY_PORT);
            IBioskop stubBioskop = (IBioskop) registry.lookup("Bioskop");
            forceRegistryHostNameOnStub(registry, stubBioskop);
            List<Bioskop> listBioskop = (List)stubBioskop.getBioskops();
            System.out.println("~Bioskop~");
            for (Bioskop b:listBioskop){ 
                System.out.println("ID: " + b.getId_film()); 
                System.out.println("Film: " + b.getNama_film()); 
                System.out.println("Bioskop: " + b.getNama_bioskop()); 
                System.out.println("Studio: " + b.getNo_studio()); 
            }
        } catch (Exception e) { 
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}