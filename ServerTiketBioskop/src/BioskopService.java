/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Annisa
 */
import java.sql.*; 
import java.util.*; 

public class BioskopService implements IBioskop{
    // Implementing the interface method 
   public List<Bioskop> getBioskops() throws Exception {  
      List<Bioskop> list = new ArrayList<>();  
    
      // JDBC driver name and database URL 
      String JDBC_DRIVER = "com.mysql.jdbc.Driver";   
      String DB_URL = "jdbc:mysql://localhost:3306/db-bioskop";  
      
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
      String sql = "SELECT * FROM tiket_bioskop"; 
      
       try (ResultSet rs = stmt.executeQuery(sql)) {
           //Extract data from result set
           while(rs.next()) {
               // Retrieve by column name
               int id_film  = rs.getInt("id_film");
               
               String nama_film = rs.getString("nama_film");
               String nama_bioskop = rs.getString("nama_bioskop");
               
               int no_studio = rs.getInt("no_studio");
               
               
               // Setting the values
               Bioskop bioskop = new Bioskop();
               bioskop.setId_film(id_film);
               bioskop.setNama_film(nama_film);
               bioskop.setNama_bioskop(nama_bioskop);
               bioskop.setNo_studio(no_studio);
               
               list.add(bioskop);
           }
       }
       return list;     
   }
}
