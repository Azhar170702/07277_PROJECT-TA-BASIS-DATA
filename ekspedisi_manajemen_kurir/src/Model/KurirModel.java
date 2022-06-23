package Model;

import Entity.KurirEnttity;
import Helper.KoneksiDb;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KurirModel {
    public Connection conn = KoneksiDb.getConnection();
    private String sql;

    public int tambahKurir(KurirEnttity kurirEnttity){
        try {
            sql = "INSERT INTO kurir(nama_kurir,alamat_kurir,no_telp,jadwal_id)VALUES(?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,kurirEnttity.getNama());
            stat.setString(2,kurirEnttity.getAlamat());
            stat.setString(3,kurirEnttity.getNoTelp());
            stat.setInt(4,kurirEnttity.getJadwal_id());
            return stat.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }
}

