package Model;

import Entity.PesananEntity;
import Helper.KoneksiDb;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;

public class PesananModel {
    public Connection conn = KoneksiDb.getConnection();
    private String sql;

    public ArrayList<PesananEntity>getPesananPenerima(int id_penerima){
        ArrayList<PesananEntity>pesananEntities = new ArrayList<>();
        try {
            sql = "SELECT pesanan.id_pesanan,penerima.nama_penerima, barang.nama_barang,status.keterangan\n" +
                    "FROM pesanan \n" +
                    "INNER JOIN penerima ON pesanan.id_penerima = penerima.id_penerima\n" +
                    "INNER JOIN barang ON pesanan.id_barang = barang.id_barang\n" +
                    "INNER JOIN status ON pesanan.status_id = status.id_status\n" +
                    "WHERE pesanan.id_penerima = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,id_penerima);
            ResultSet rs = stat.executeQuery();

            while (rs.next()){
                PesananEntity pesanan = new PesananEntity();
                pesanan.setId(rs.getInt("id_pesanan"));
                pesanan.setNama_penerima(rs.getString("penerima.nama_penerima"));
                pesanan.setNama_barang(rs.getString("barang.nama_barang"));
                pesanan.setStatus(rs.getString("status.keterangan"));
                pesananEntities.add(pesanan);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return pesananEntities;
    }

    public int updatePesananPenerima(int id_pesanan){
        try{
            sql = "UPDATE pesanan SET status_id = 3, tanggal_diterima = NOW() WHERE id_pesanan = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,id_pesanan);
            return stat.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public ArrayList<PesananEntity>getPesananPenerima(){
        ArrayList<PesananEntity>pesananEntities = new ArrayList<>();
        try {
            sql = "SELECT pesanan.id_pesanan,penerima.nama_penerima,penerima.alamat, barang.nama_barang,status.keterangan\n" +
                    "FROM pesanan \n" +
                    "INNER JOIN penerima ON pesanan.id_penerima = penerima.id_penerima\n" +
                    "INNER JOIN barang ON pesanan.id_barang = barang.id_barang\n" +
                    "INNER JOIN status ON pesanan.status_id = status.id_status\n" +
                    "WHERE pesanan.status_id = 1";
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();

            while (rs.next()){
                PesananEntity pesanan = new PesananEntity();
                pesanan.setId(rs.getInt("id_pesanan"));
                pesanan.setNama_penerima(rs.getString("penerima.nama_penerima"));
                pesanan.setAlamat_penerima(rs.getString("penerima.alamat"));
                pesanan.setNama_barang(rs.getString("barang.nama_barang"));
                pesanan.setStatus(rs.getString("status.keterangan"));
                pesananEntities.add(pesanan);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return pesananEntities;
    }

    public ArrayList<PesananEntity>getPesananTerkirim(){
        ArrayList<PesananEntity>pesananEntities = new ArrayList<>();
        try{
            sql = "SELECT pesanan.id_pesanan,penerima.nama_penerima,penerima.alamat, kurir.nama_kurir,barang.nama_barang, status.keterangan, tanggal_pengiriman\n" +
                    "FROM pesanan\n" +
                    "INNER JOIN penerima ON pesanan.id_penerima = penerima.id_penerima\n" +
                    "INNER JOIN kurir ON pesanan.id_kurir = kurir.id_kurir\n" +
                    "INNER JOIN barang ON pesanan.id_barang = barang.id_barang\n" +
                    "INNER JOIN status ON pesanan.status_id = status.id_status\n" +
                    "WHERE pesanan.status_id = 2";
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();

            while (rs.next()){
                PesananEntity pesanan = new PesananEntity();
                pesanan.setId(rs.getInt("id_pesanan"));
                pesanan.setNama_penerima(rs.getString("penerima.nama_penerima"));
                pesanan.setNama_kurir(rs.getString("kurir.nama_kurir"));
                pesanan.setNama_barang(rs.getString("barang.nama_barang"));
                pesanan.setStatus(rs.getString("status.keterangan"));
                pesanan.setTanggal(rs.getString("tanggal_pengiriman"));
                pesananEntities.add(pesanan);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return pesananEntities;
    }

    public ArrayList<PesananEntity>getPesananDiterima(){
        ArrayList<PesananEntity>pesananEntities = new ArrayList<>();
        try{
            sql = "SELECT pesanan.id_pesanan,penerima.nama_penerima,penerima.alamat, kurir.nama_kurir,barang.nama_barang, status.keterangan, tanggal_diterima\n" +
                    "FROM pesanan\n" +
                    "INNER JOIN penerima ON pesanan.id_penerima = penerima.id_penerima\n" +
                    "INNER JOIN kurir ON pesanan.id_kurir = kurir.id_kurir\n" +
                    "INNER JOIN barang ON pesanan.id_barang = barang.id_barang\n" +
                    "INNER JOIN status ON pesanan.status_id = status.id_status\n" +
                    "WHERE pesanan.status_id = 3";
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();

            while (rs.next()){
                PesananEntity pesanan = new PesananEntity();
                pesanan.setId(rs.getInt("id_pesanan"));
                pesanan.setNama_penerima(rs.getString("penerima.nama_penerima"));
                pesanan.setAlamat_penerima(rs.getString("penerima.alamat"));
                pesanan.setNama_kurir(rs.getString("kurir.nama_kurir"));
                pesanan.setNama_barang(rs.getString("barang.nama_barang"));
                pesanan.setStatus(rs.getString("status.keterangan"));
                pesanan.setTanggal(rs.getString("tanggal_diterima"));
                pesananEntities.add(pesanan);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return pesananEntities;
    }



    public int updatePesanan(int id_kurir,int id_pesanan){
        try{
            sql = "UPDATE pesanan SET id_kurir = ?, tanggal_pengiriman = NOW(), status_id = 2 WHERE id_pesanan = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,id_kurir);
            stat.setInt(2,id_pesanan);
            return stat.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }
}
