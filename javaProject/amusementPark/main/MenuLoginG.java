package javaProject.amusementPark.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuLoginG extends JFrame {
    public static void main(String[] args) {
        new MenuLoginG();
    }

    public MenuLoginG() {
        this.setTitle("Amusement Park Program");
        this.setBounds(100, 100, 240, 150);
        this.setLayout(null);
        JButton login = new JButton("로그인");
        login.setBounds(10,20,200,30);
        add(login);
        JButton signIn = new JButton("회원가입");
        signIn.setBounds(10,70,200,30);
        add(signIn);

        login.addActionListener(e -> new LoginG());
        signIn.addActionListener(e -> new SignInG());

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }


}

