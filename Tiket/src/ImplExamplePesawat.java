import java.sql.*; 
import java.util.*;  

// Implementing the remote interface 
public class ImplExamplePesawat implements HelloPesawat {  
   
   // Implementing the interface method 
   public List<Pesawat> getPesawats() throws Exception {  
      List<Pesawat> list = new ArrayList<Pesawat>();   
    
      // JDBC driver name and database URL 
      String JDBC_DRIVER = "com.mysql.jdbc.Driver";   
      String DB_URL = "jdbc:mysql://localhost:3306/ticketing";  
      
      // Database credentials 
      String USER = "root"; 
      String PASS = "";  
      
      Connection conn = null; 
      Statement stmt = null;  
      
      //Register JDBC driver 
      Class.forName("com.mysql.jdbc.Driver");   
      
      //Open a connection
      System.out.println("Connecting to a selected database..."); 
      conn = DriverManager.getConnection(DB_URL, USER, PASS); 
      System.out.println("Connected database successfully...");  
      
      //Execute a query 
      System.out.println("Creating statement..."); 
      
      stmt = conn.createStatement();  
      String sql = "SELECT * FROM tiket_pesawat"; 
      ResultSet rs = stmt.executeQuery(sql);  
      
      //Extract data from result set 
      while(rs.next()) { 
         // Retrieve by column name 
         int id_penerbangan  = rs.getInt("id_penerbangan"); 
         
         String maskapai = rs.getString("maskapai"); 
         String asal = rs.getString("asal"); 
         String tujuan = rs.getString("tujuan");
         String tanggal_keberangkatan = rs.getString("tanggal_keberangkatan");  

         
         // Setting the values 
         Pesawat pesawat = new Pesawat(); 
         pesawat.setId(id_penerbangan); 
         pesawat.setMaskapai(maskapai); 
         pesawat.setAsal(asal); 
         pesawat.setTujuan(tujuan); 
         pesawat.setTanggal(tanggal_keberangkatan); 
         list.add(pesawat); 
      } 
      rs.close(); 
      return list;     
   }  
}