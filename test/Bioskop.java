public class Bioskop implements java.io.Serializable {
    private int id_film, no_studio;
    private String nama_film, nama_bioskop;

    public int getId_film() {
        return id_film;
    }

    public int getNo_studio() {
        return no_studio;
    }

    public String getNama_film() {
        return nama_film;
    }

    public String getNama_bioskop() {
        return nama_bioskop;
    }

    public void setId_film(int id_film) {
        this.id_film = id_film;
    }

    public void setNo_studio(int no_studio) {
        this.no_studio = no_studio;
    }

    public void setNama_film(String nama_film) {
        this.nama_film = nama_film;
    }

    public void setNama_bioskop(String nama_bioskop) {
        this.nama_bioskop = nama_bioskop;
    }
}
