package GUI;

import Controller.AllObjectModel;
import Helper.KoneksiDb;

import javax.management.relation.RelationSupport;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TambahKurirGui extends JFrame {
    JLabel lblNama = new JLabel("NAMA");
    JLabel lblAlamat = new JLabel("ALAMAT");
    JLabel lblNotelp = new JLabel("NO TELP");
    JLabel lblJadwalKerja = new JLabel("JADWAL KERJA");
    JButton btnKembali = new JButton("Kembali");
    JTextField fieldAlamat = new JTextField();
    JTextField fieldNama = new JTextField();
    JTextField fieldNoTelp = new JTextField();
    JComboBox comboBox = new JComboBox();
    JButton btnTambah = new JButton("Tambah");
    
    TambahKurirGui(int id){
        initComponent(id);
    }
    
    public void initComponent(int id){
        setBounds(100, 100, 450, 415);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setLayout(null);
       
        lblNama.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblNama.setBounds(10, 56, 107, 46);
        this.add(lblNama);

        lblAlamat.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblAlamat.setBounds(10, 113, 107, 46);
        this.add(lblAlamat);

        lblNotelp.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblNotelp.setBounds(10, 182, 107, 46);
        this.add(lblNotelp);

        lblJadwalKerja.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblJadwalKerja.setBounds(10, 239, 129, 46);
        this.add(lblJadwalKerja);

        btnKembali.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnKembali.setBounds(10, 11, 89, 29);
        this.add(btnKembali);
        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DashboardGui(id);
                dispose();
            }
        });

        fieldNama.setBounds(161, 67, 201, 29);
        this.add(fieldNama);
        fieldNama.setColumns(10);

        fieldAlamat.setColumns(10);
        fieldAlamat.setBounds(161, 128, 201, 29);
        this.add(fieldAlamat);

        
        fieldNoTelp.setColumns(10);
        fieldNoTelp.setBounds(161, 193, 201, 29);
        this.add(fieldNoTelp);

        comboBox.setBounds(161, 254, 201, 29);
        JadwalKerja();
        this.add(comboBox);

        btnTambah.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnTambah.setBounds(171, 320, 89, 29);
        this.add(btnTambah);
        btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = fieldNama.getText();
                String alamat = fieldAlamat.getText();
                String noTelp = fieldNoTelp.getText();
                int jadwal_kerja = comboBox.getSelectedIndex() + 1;

                if(nama.isEmpty() || alamat.isEmpty() || noTelp.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Tidak boleh kosong");
                }else {
                    AllObjectController.kurirController.insertData(nama,alamat,noTelp,jadwal_kerja);
                    JOptionPane.showMessageDialog(null,"Berhasil Ditambahkan");
                    new DashboardGui(id);
                    dispose();
                }
            }
        });

        setVisible(true);
    }

    public void JadwalKerja(){
        String sql;
        Connection conn = KoneksiDb.getConnection();
        try{
            sql = "SELECT * FROM jadwal_kerja";
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();

            while (rs.next()){
                String jadwal = rs.getString("day");
                comboBox.addItem(jadwal);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
}
