package GUI;

import Controller.AllObjectModel;
import Helper.KoneksiDb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PengirimGui extends JFrame {
    JTable tablePesanan = new JTable();
    JScrollPane spPesanan = new JScrollPane(tablePesanan);
    JTextField fieldId = new JTextField();
    JComboBox comboBox = new JComboBox();

    PengirimGui(int id){
        initComponent(id);
    }

    public void initComponent(int id){
       setBounds(100, 100, 658, 486);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLocationRelativeTo(null);
       getContentPane().setLayout(null);

       spPesanan.setBounds(0, 0, 510, 365);
       tablePesanan.setModel(AllObjectController.pesananController.daftarPesananPenerima());
       this.add(spPesanan);

       tablePesanan.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               int i = tablePesanan.getSelectedRow();
               fieldId.setText(String.valueOf(tablePesanan.getValueAt(i,0)));
           }
       });

       //ComboBoxKurir
        comboBox.setBounds(519, 28, 113, 28);
        comboBoxKurir();
        this.add(comboBox);

       //BtnKirim
        JButton btnKirim = new JButton("KIRIM");
        btnKirim.addActionListener(new ActionListener() {
            int id_pesanan;
            public void actionPerformed(ActionEvent e) {
                     id_pesanan = Integer.parseInt(fieldId.getText());
                     int kurir = comboBox.getSelectedIndex() + 1;
//                     JOptionPane.showMessageDialog(null,"Pesanan: "+id_pesanan+ " Kurir : "+kurir);
              int cek = AllObjectModel.pesananModel.updatePesanan(kurir,id_pesanan);
              if(cek > 0){
                 JOptionPane.showMessageDialog(null,"Berhasil Kirim");
                tablePesanan.setModel(AllObjectController.pesananController.daftarPesananPenerima());
              }
            }
        });
        btnKirim.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnKirim.setBounds(518, 78, 114, 28);
        this.add(btnKirim);

        //BtnTerkirim
        JButton btnTerkirim = new JButton("TERKIRIM");
        btnTerkirim.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TerkirimGui(id);
                dispose();
            }
        });
        btnTerkirim.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnTerkirim.setBounds(518, 132, 114, 28);
        this.add(btnTerkirim);

        //BtnDiterima
        JButton btnDiterima = new JButton("DITERIMA");
        btnDiterima.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TerimaGui(id);
                dispose();
            }
        });
        btnDiterima.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnDiterima.setBounds(518, 183, 114, 28);
        this.add(btnDiterima);

        //BtnKeluar
        JButton btnKeluar = new JButton("KELUAR");
        btnKeluar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DashboardGui(id);
                dispose();
            }
        });
        btnKeluar.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnKeluar.setBounds(518, 233, 114, 28);
        this.add(btnKeluar);









       setVisible(true);

    }

    public void comboBoxKurir(){
        Connection conn = KoneksiDb.getConnection();
        String sql;

        try{
            sql = "SELECT * FROM kurir";
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();

            while (rs.next()){
                String nama = rs.getString("nama_kurir");
                comboBox.addItem(nama);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
