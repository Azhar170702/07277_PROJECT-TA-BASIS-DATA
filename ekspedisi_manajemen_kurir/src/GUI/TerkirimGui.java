package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TerkirimGui extends JFrame {
    JTable tableTerkirim = new JTable();
    JScrollPane spTerkirim = new JScrollPane(tableTerkirim);
    TerkirimGui(int id){
        initComponent(id);
    }

    public void initComponent(int id){
        setBounds(100, 100, 535, 457);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);


        spTerkirim.setBounds(37, 46, 446, 316);
        tableTerkirim.setModel(AllObjectController.pesananController.daftarPesananTerkirim());
        this.add(spTerkirim);

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
