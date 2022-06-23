package Entity;

public class PenerimaEntity {
    private String nama_penerima,password,alamat;

    public PenerimaEntity(String nama_penerima, String password) {
        this.nama_penerima = nama_penerima;
        this.password = password;
    }

    public String getNama_penerima() {
        return nama_penerima;
    }

    public void setNama_penerima(String nama_penerima) {
        this.nama_penerima = nama_penerima;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
