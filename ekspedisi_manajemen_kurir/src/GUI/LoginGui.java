package GUI;

import Controller.AllObjectModel;

import javax.print.attribute.standard.JobPriority;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGui extends JFrame {
    JTextField fieldUsername = new JTextField();
    JPasswordField fieldPassword = new JPasswordField();
    JButton btnLogin = new JButton("LOGIN");

    LoginGui(){
        initComponent();
    }
    
    public void initComponent(){
        setBounds(100, 100, 479, 314);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);

        JLabel labelUsername = new JLabel("USERNAME");
        labelUsername.setFont(new Font("Times New Roman", Font.BOLD, 17));
        labelUsername.setBounds(25, 51, 102, 34);
        this.add(labelUsername);

        JLabel lblPassword = new JLabel("PASSWORD");
        lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblPassword.setBounds(25, 127, 117, 34);
        this.add(lblPassword);

        fieldUsername.setBounds(220, 53, 161, 34);
        this.add(fieldUsername);


        fieldPassword.setColumns(10);
        fieldPassword.setBounds(220, 127, 161, 34);
        this.add(fieldPassword);


        btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnLogin.setBounds(183, 212, 108, 34);
        this.add(btnLogin);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = fieldUsername.getText();
                String password = fieldPassword.getText();
                int cek = AllObjectModel.admin_model.cekLogin(username,password);
                int cek2 = AllObjectModel.penerimaModel.Login(username,password);
                if(cek > 0){
                    JOptionPane.showMessageDialog(null,"Berhasil Login");
                    new DashboardGui(cek);
                    dispose();
                }else if(cek2 > 0){
                    JOptionPane.showMessageDialog(null,"Berhasil Login");
                    new PenerimaGui(cek2);
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null,"Username atau password salah");
                };
            }
        });

        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new LoginGui();
    }
}
