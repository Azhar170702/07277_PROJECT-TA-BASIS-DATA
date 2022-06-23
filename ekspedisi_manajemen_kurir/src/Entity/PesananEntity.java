package Entity;

public class PesananEntity {
    private String nama_barang,nama_penerima,status,nama_kurir,alamat_penerima,tanggal;
    private int id;

    public PesananEntity(String nama_barang, String nama_penerima, String status) {
        this.nama_barang = nama_barang;
        this.nama_penerima = nama_penerima;
        this.status = status;
    }

    public PesananEntity(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getNama_penerima() {
        return nama_penerima;
    }

    public void setNama_penerima(String nama_penerima) {
        this.nama_penerima = nama_penerima;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNama_kurir() {
        return nama_kurir;
    }

    public void setNama_kurir(String nama_kurir) {
        this.nama_kurir = nama_kurir;
    }

    public String getAlamat_penerima() {
        return alamat_penerima;
    }

    public void setAlamat_penerima(String alamat_penerima) {
        this.alamat_penerima = alamat_penerima;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
