package chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatMemG extends JFrame implements ActionListener {
    private JButton jButton1 = new JButton("놀이공원");
    private JButton jButton2 = new JButton("음식점");
    private JButton jButton3 = new JButton("티켓");
    private String id;

    public ChatMemG(String id) {
        this.id = id;
        this.setBounds(100, 100, 450, 300);
        this.setLayout(new GridLayout(3,1));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.add(jButton1);
        this.add(jButton2);
        this.add(jButton3);

        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        jButton3.addActionListener(this);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jButton1) {
            new ClientV3(id,0);
        }else if(e.getSource() == jButton2) {
            new ClientV3(id,1);
        }else if(e.getSource() == jButton3) {
            new ClientV3(id,2);
        }
    }
}
