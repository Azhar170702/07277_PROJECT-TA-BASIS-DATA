package Controller;

import Entity.BarangEntity;

import javax.swing.table.DefaultTableModel;
import java.io.ObjectStreamException;
import java.util.ArrayList;

public class BarangController {

    public ArrayList<BarangEntity>getAllBarang(){
        return AllObjectModel.barangModel.getBarang();
    }

    public DefaultTableModel daftarBarang(){
        DefaultTableModel daftarBarang = new DefaultTableModel();
        Object[]kolom = {"ID","Nama","Jenis"};
        daftarBarang.setColumnIdentifiers(kolom);
        int size = getAllBarang().size();

        for(int i = 0; i<size; i++){
            Object[]data = new Object[kolom.length];
            data[0] = getAllBarang().get(i).getId();
            data[1] = getAllBarang().get(i).getNama_barang();
            data[2] = getAllBarang().get(i).getJenis_barang();
            daftarBarang.addRow(data);
        }
       return daftarBarang;
    }
}
