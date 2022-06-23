package GUI;

import Controller.AllObjectModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PesananPenerimaGui extends JFrame {
    JTable tablePenerimaPesanan = new JTable();
    JScrollPane spPenerima = new JScrollPane(tablePenerimaPesanan);
    JButton btnPenerimaPesanan = new JButton("PESANAN DITERIMA");
    JButton btnKeluar = new JButton("KELUAR");
    JTextField textPilih = new JTextField();
    JTextField fieldId = new JTextField();
    JTextField fieldStatus = new JTextField();

    PesananPenerimaGui(int id){
        initComponent(id);
    }

    public void initComponent(int id){
        setBounds(100, 100, 681, 497);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        spPenerima.setBounds(0, 0, 488, 336);
        tablePenerimaPesanan.setModel(AllObjectController.pesananController.daftarPesananPenerima(id));
        this.add(spPenerima);

        tablePenerimaPesanan.addMouseListener(new MouseAdapter() {
            String staus;
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tablePenerimaPesanan.getSelectedRow();
                fieldId.setText(String.valueOf(tablePenerimaPesanan.getValueAt(i,0)));
                staus = AllObjectController.pesananController.getPesananPenerima(id).get(i).getStatus();
                fieldStatus.setText(staus);
            }
        });


        btnPenerimaPesanan.addActionListener(new ActionListener() {
           private int id_pesanan;
           private String status;
            public void actionPerformed(ActionEvent e) {
                id_pesanan = Integer.parseInt(String.valueOf(fieldId.getText()));
                status = fieldStatus.getText();
                if(status.equals("Diproses")){
                    JOptionPane.showMessageDialog(null,"Pesanan Masih belum dikirim");
                }else {
                   int confirm = JOptionPane.showConfirmDialog(null,"Terima Pesanan?");
                   if(confirm == 0){
                      int cek =  AllObjectController.pesananController.updatePesananPenerima(id_pesanan);
                      if(cek > 0){
                          JOptionPane.showMessageDialog(null,"Berhasil Diterima");
                          tablePenerimaPesanan.setModel(AllObjectController.pesananController.daftarPesananPenerima(id));
                      }
                   }
                }
            }
        });

        btnPenerimaPesanan.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnPenerimaPesanan.setBounds(498, 21, 157, 36);
        this.add(btnPenerimaPesanan);


        btnKeluar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PenerimaGui(id);
                dispose();
            }
        });
        btnKeluar.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnKeluar.setBounds(498, 85, 157, 36);
        this.add(btnKeluar);




        setVisible(true);
    }
}
