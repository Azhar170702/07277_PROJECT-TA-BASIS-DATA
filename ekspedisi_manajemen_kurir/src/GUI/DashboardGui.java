package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardGui extends JFrame {
    JButton btnTambahKurir = new JButton("TAMBAH KURIR");
    JButton btnPesanan = new JButton("PESANAN");
    JButton btnKeluar = new JButton("KELUAR");

    DashboardGui(int id){
        initComponent(id);
    }

    public void initComponent(int id){
        setBounds(100, 100, 419, 238);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        
        btnTambahKurir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TambahKurirGui(id);
                dispose();
            }
        });
        btnTambahKurir.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnTambahKurir.setBounds(36, 53, 135, 85);
        this.add(btnTambahKurir);

        btnPesanan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PengirimGui(id);
                dispose();
            }
        });
        btnPesanan.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnPesanan.setBounds(218, 53, 125, 85);
        this.add(btnPesanan);

        
        btnKeluar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoginGui();
                dispose();
            }
        });
        btnKeluar.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnKeluar.setBounds(38, 11, 89, 23);
        this.add(btnKeluar);

        setVisible(true);

    }

}
