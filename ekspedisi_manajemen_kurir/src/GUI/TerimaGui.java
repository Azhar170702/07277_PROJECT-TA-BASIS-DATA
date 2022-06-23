package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TerimaGui extends JFrame {
    JTable terimaPesanan = new JTable();
    JScrollPane spTerima = new JScrollPane(terimaPesanan);

    TerimaGui(int id){
        initComponent(id);
    }

    public void initComponent(int id){
        setBounds(100, 100, 650, 463);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

       spTerima.setBounds(37, 46, 570, 328);
       terimaPesanan.setModel(AllObjectController.pesananController.daftarPesananDiterima());
       this.add(spTerima);

        JButton btnKembali = new JButton("KEMBALI");
        btnKembali.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PengirimGui(id);
                dispose();
            }
        });
        btnKembali.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnKembali.setBounds(34, 11, 107, 23);
        this.add(btnKembali);
        setVisible(true);
    }
}
