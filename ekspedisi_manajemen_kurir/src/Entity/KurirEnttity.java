package Entity;

public class KurirEnttity {
    private String nama,alamat,noTelp;
    private int jadwal_id;

    public KurirEnttity(String nama, String alamat, String noTelp, int jadwal_id) {
        this.nama = nama;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.jadwal_id = jadwal_id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public int getJadwal_id() {
        return jadwal_id;
    }

    public void setJadwal_id(int jadwal_id) {
        this.jadwal_id = jadwal_id;
    }
}
