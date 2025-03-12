package javaProject.amusementPark.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class LoginG extends JFrame {

    public LoginG() {
        this.setTitle("로그인");
        this.setLayout(null);
        JLabel id = new JLabel("아이디");
        id.setSize(30, 30);
        JLabel pass = new JLabel("비밀번호");
        pass.setSize(30, 30);
        JTextField idF = new JTextField(10);
        idF.setSize(70, 30);
        JTextField passF = new JTextField(10);
        passF.setSize(70, 30);
        JPanel panel = new JPanel();
        JPanel panelF = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        panelF.setLayout(new GridLayout(2, 1));
        panel.setBounds(0, 5, 50, 60);
        panelF.setBounds(60, 5, 150, 60);
        panel.add(id);
        panelF.add(idF);
        panel.add(pass);
        panelF.add(passF);
        this.add(panel);
        this.add(panelF);
        Font font = new Font("맑은고딕", Font.BOLD, 10);
        JButton loginBtn = new JButton("로그인");
        loginBtn.setFont(font);
        loginBtn.setBounds(210, 5, 65, 60);
        this.add(loginBtn);
        this.setBounds(100, 130, 295, 110);
        this.setVisible(true);

        loginBtn.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(e.getSource() == loginBtn) {
                    String id = idF.getText();
                    String pass = passF.getText();
                    // 로그인 메서드 넣기
                    JOptionPane.showMessageDialog(loginBtn,"로그인성공");
                    dispose();

                }
            }
        });

    }


}
