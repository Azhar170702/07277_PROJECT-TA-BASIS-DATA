package Model;

import Helper.KoneksiDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PenerimaModel {
    public Connection conn = KoneksiDb.getConnection();
    private String sql;

    public int Login(String nama, String password){
        try{
            sql = "SELECT * FROM penerima WHERE nama_penerima = ? AND password = ? ";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,nama);
            stat.setString(2,password);
            ResultSet rs = stat.executeQuery();

            if(rs.next()){
                return rs.getInt("id_penerima");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }


}
