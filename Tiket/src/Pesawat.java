public class Pesawat implements java.io.Serializable {   
   private int id_penerbangan;   
   private String maskapai, asal, tujuan, tanggal_keberangkatan;    
  
   public int getId() { 
      return id_penerbangan; 
   } 
   public String getMaskapai() { 
      return maskapai; 
   } 
   public String getAsal() { 
      return asal; 
   } 
   
    public String getTujuan() { 
      return asal; 
   } 

   public String getTanggal() { 
      return tanggal_keberangkatan; 
   } 
   
   public void setId(int id_penerbangan) { 
      this.id_penerbangan = id_penerbangan; 
   } 
   
   public void setMaskapai(String maskapai) { 
      this.maskapai = maskapai; 
   } 
   
   public void setAsal(String asal) { 
      this.asal = asal; 
   } 
   
   public void setTujuan(String tujuan) { 
      this.tujuan = tujuan; 
   } 
   
   public void setTanggal(String tanggal_keberangkatan) { 
      this.tanggal_keberangkatan = tanggal_keberangkatan; 
   } 
}