package GUI;

import Helper.KoneksiDb;
import com.mysql.cj.protocol.a.NativeUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PenerimaGui extends JFrame {
    JTable tableBarang = new JTable();
    JScrollPane spBarang = new JScrollPane(tableBarang);
    JTextField textpilih = new JTextField();
    JButton btnKeluar = new JButton("KELUAR");
    JTextField fieldId = new JTextField();
    JButton btnBeli = new JButton("BELI");
    JButton btnPesanan = new JButton("PESANAN");

    PenerimaGui(int id) {
        initComponent(id);
    }

    public void initComponent(int id) {
        setBounds(100, 100, 598, 479);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        spBarang.setBounds(0, 0, 443, 366);
        tableBarang.setModel(AllObjectController.barangController.daftarBarang());
        this.add(spBarang);

        tableBarang.addMouseListener(new MouseAdapter() {
            private int id;

            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tableBarang.getSelectedRow();
                textpilih.setText(AllObjectController.barangController.daftarBarang().getValueAt(i, 0).toString());
                id = AllObjectController.barangController.getAllBarang().get(i).getId();
                fieldId.setText(String.valueOf(id));
            }
        });

        fieldId.setBounds(0, 0, 0, 0);
        fieldId.setVisible(false);
        this.add(fieldId);


        btnKeluar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoginGui();
                dispose();
            }
        });
        btnKeluar.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnKeluar.setBounds(453, 153, 115, 30);
        this.add(btnKeluar);

        btnBeli.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnBeli.setBounds(453, 25, 115, 30);
        this.add(btnBeli);
        btnBeli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id_barang = Integer.parseInt(String.valueOf(fieldId.getText()));
                transaksi(id_barang,id);
            }
        });


        btnPesanan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PesananPenerimaGui(id);
                dispose();
            }
        });
        btnPesanan.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnPesanan.setBounds(453, 90, 115, 30);
        this.add(btnPesanan);


        setVisible(true);
    }
    public void transaksi(int id_penerima, int id_barang){
        Connection conn = KoneksiDb.getConnection();
        String sql;

        try{
            sql = "INSERT INTO pesanan(id_barang,id_penerima,id_kurir,status_id,tanggal_pengiriman,tanggal_diterima)" +
                    " VALUES(?,?,NULL,1,NULL,NULL)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,id_penerima);
            stat.setInt(2,id_barang);
            JOptionPane.showMessageDialog(null,"Berhasil Beli");
            stat.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}

