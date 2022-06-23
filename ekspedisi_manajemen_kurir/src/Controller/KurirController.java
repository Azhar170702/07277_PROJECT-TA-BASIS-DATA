package Controller;

import Entity.KurirEnttity;

public class KurirController {
    public int insertData(String nama,String alamat, String no_Telp, int jadwal_id){
        return AllObjectModel.kurirModel.tambahKurir(new KurirEnttity(nama,alamat,no_Telp,jadwal_id));
    }
}
