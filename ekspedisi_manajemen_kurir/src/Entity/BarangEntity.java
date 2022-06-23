package Entity;

public class BarangEntity {
    private String nama_barang, jenis_barang;
    private int id;
    public BarangEntity(){}

    public BarangEntity(int id,String nama_barang, String jenis_barang) {
        this.nama_barang = nama_barang;
        this.jenis_barang = jenis_barang;
    }

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

    public String getJenis_barang() {
        return jenis_barang;
    }

    public void setJenis_barang(String jenis_barang) {
        this.jenis_barang = jenis_barang;
    }
}
