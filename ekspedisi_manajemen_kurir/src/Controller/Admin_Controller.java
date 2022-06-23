package Controller;

public class Admin_Controller {
    public int Login(String username, String password){
        return AllObjectModel.admin_model.cekLogin(username, password);
    }
}
