package Model;

import Entity.BarangEntity;
import Helper.KoneksiDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BarangModel {
    public Connection conn = KoneksiDb.getConnection();
    private String sql;

    public ArrayList<BarangEntity>getBarang(){
        ArrayList<BarangEntity>barangEntities = new ArrayList<>();
        try{
            sql = "SELECT * FROM barang";
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();

            while (rs.next()){
                BarangEntity barang = new BarangEntity();
                barang.setId(rs.getInt("id_barang"));
                barang.setNama_barang(rs.getString("nama_barang"));
                barang.setJenis_barang(rs.getString("jenis_barang"));
                barangEntities.add(barang);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return barangEntities;
    }

}
