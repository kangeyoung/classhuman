package javaProject.amusementPark.main;

import javax.swing.*;
import java.awt.*;

public class SignInG extends JFrame {
    public SignInG() {
        this.setLayout(null);
        this.setBounds(100, 150, 500, 400);
        JPanel panel = new JPanel();
        JLabel id = new JLabel("아이디");
        id.setSize(30,30);
        JLabel pass = new JLabel("비밀번호");
        pass.setSize(30,30);
        JLabel name = new JLabel("이름");
        name.setSize(30,30);
        JLabel gender = new JLabel("성별");
        gender.setSize(30,30);
        JLabel birth = new JLabel("생년월일");
        birth.setSize(30,30);

        JTextField idF = new JTextField();

        JTextField passF = new JTextField();
        JTextField nameF = new JTextField();
        JTextField genderF = new JTextField();
        JTextField birthF = new JTextField();

        this.setVisible(true);




    }
}
