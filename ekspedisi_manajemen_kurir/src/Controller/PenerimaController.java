package Controller;

public class PenerimaController {
    public int Login(String nama, String password){
        return AllObjectModel.penerimaModel.Login(nama, password);
    }
}
