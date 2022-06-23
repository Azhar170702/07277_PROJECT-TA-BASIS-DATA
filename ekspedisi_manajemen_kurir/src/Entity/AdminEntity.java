package Entity;

public class AdminEntity {
    private String nama,password;

    public AdminEntity(String nama, String password) {
        this.nama = nama;
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
