package Model;

import Helper.KoneksiDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin_Model {
    public Connection conn = KoneksiDb.getConnection();
    private String sql;

    public int cekLogin(String username, String password){
        try{
            sql = "SELECT * FROM admin_kurir WHERE nama_admin = ?  AND password_admin = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,username);
            stat.setString(2,password);
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
                return rs.getInt("id_admin");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }


}
