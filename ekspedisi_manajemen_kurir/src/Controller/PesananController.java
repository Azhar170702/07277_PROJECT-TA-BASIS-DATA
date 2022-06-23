package Controller;

import Entity.PesananEntity;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class PesananController {

    public ArrayList<PesananEntity>getPesananPenerima(int id){
        return AllObjectModel.pesananModel.getPesananPenerima(id);
    }

    public ArrayList<PesananEntity>getPesananPenerima(){
        return AllObjectModel.pesananModel.getPesananPenerima();
    }

    public ArrayList<PesananEntity>getPesananTerkirim(){
        return AllObjectModel.pesananModel.getPesananTerkirim();
    }

    public ArrayList<PesananEntity>getPesananDiterima(){
        return AllObjectModel.pesananModel.getPesananDiterima();
    }

    public DefaultTableModel daftarPesananPenerima(int id){
        DefaultTableModel dafttarPenerima= new DefaultTableModel();
        Object[]kolom = {"ID","NAMA","BARANG","STATUS"};
        dafttarPenerima.setColumnIdentifiers(kolom);
        int size = getPesananPenerima(id).size();

        for(int i = 0; i<size; i++){
            Object[]data = new Object[kolom.length];
            data[0] = getPesananPenerima(id).get(i).getId();
            data[1] = getPesananPenerima(id).get(i).getNama_penerima();
            data[2] = getPesananPenerima(id).get(i).getNama_barang();
            data[3] = getPesananPenerima(id).get(i).getStatus();
            dafttarPenerima.addRow(data);
        }
        return dafttarPenerima;
    }

    public int updatePesananPenerima(int id_pesanan){
        return AllObjectModel.pesananModel.updatePesananPenerima(id_pesanan);
    }

    public DefaultTableModel daftarPesananPenerima(){
        DefaultTableModel dafttarPenerima= new DefaultTableModel();
        Object[]kolom = {"ID","NAMA","ALAMAT","BARANG","STATUS"};
        dafttarPenerima.setColumnIdentifiers(kolom);
        int size = getPesananPenerima().size();

        for(int i = 0; i<size; i++){
            Object[]data = new Object[kolom.length];
            data[0] = getPesananPenerima().get(i).getId();
            data[1] = getPesananPenerima().get(i).getNama_penerima();
            data[2] = getPesananPenerima().get(i).getAlamat_penerima();
            data[3] = getPesananPenerima().get(i).getNama_barang();
            data[4] = getPesananPenerima().get(i).getStatus();
            dafttarPenerima.addRow(data);
        }
        return dafttarPenerima;
    }

    public DefaultTableModel daftarPesananTerkirim(){
        DefaultTableModel dafttarPenerima= new DefaultTableModel();
        Object[]kolom = {"ID","NAMA","KURIR","BARANG","STATUS","TANGGAL"};
        dafttarPenerima.setColumnIdentifiers(kolom);
        int size = getPesananTerkirim().size();

        for(int i = 0; i<size; i++){
            Object[]data = new Object[kolom.length];
            data[0] = getPesananTerkirim().get(i).getId();
            data[1] = getPesananTerkirim().get(i).getNama_penerima();
            data[2] = getPesananTerkirim().get(i).getNama_kurir();
            data[3] = getPesananTerkirim().get(i).getNama_barang();
            data[4] = getPesananTerkirim().get(i).getStatus();
            data[5] = getPesananTerkirim().get(i).getTanggal();
            dafttarPenerima.addRow(data);
        }
        return dafttarPenerima;
    }

    public DefaultTableModel daftarPesananDiterima(){
        DefaultTableModel dafttarPenerima= new DefaultTableModel();
        Object[]kolom = {"ID","NAMA","ALAMAT","KURIR","BARANG","STATUS","TANGGAL"};
        dafttarPenerima.setColumnIdentifiers(kolom);
        int size =getPesananDiterima().size();

        for(int i = 0; i<size; i++){
            Object[]data = new Object[kolom.length];
            data[0] =getPesananDiterima().get(i).getId();
            data[1] =getPesananDiterima().get(i).getNama_penerima();
            data[2] =getPesananDiterima().get(i).getAlamat_penerima();
            data[3] = getPesananDiterima().get(i).getNama_kurir();
            data[4] = getPesananDiterima().get(i).getNama_barang();
            data[5] = getPesananDiterima().get(i).getStatus();
            data[6] = getPesananDiterima().get(i).getTanggal();
            dafttarPenerima.addRow(data);
        }
        return dafttarPenerima;
    }

}
