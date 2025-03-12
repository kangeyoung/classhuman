package mar10.Guitest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GuiMain extends JFrame implements ActionListener {
    private JLabel j1 = new JLabel("휴먼 word system");
    private JButton btn1 = new JButton("Save");
    private DefaultListModel model = new DefaultListModel();
    private JList l1 = new JList(model);
    private JTextField t1 = new JTextField();
    private JPanel p1 = new JPanel();
    private JLabel id = new JLabel("ID");
    private JLabel name = new JLabel("Name");
    private JLabel addr = new JLabel("Addr");
    private JTextField idf = new JTextField(10);
    private JTextField namef = new JTextField(10);
    private JTextField addrf = new JTextField(10);

    public GuiMain() {
        //System.out.println("환영합니다.");
        this.setBounds(100, 200, 300, 150);
        this.setTitle("환영합니다.");
        p1.setBackground(Color.yellow);
        p1.setLayout(new GridLayout(3, 2));
        p1.add(id);
        p1.add(idf);
        p1.add(name);
        p1.add(namef);
        p1.add(addr);
        p1.add(addrf);
        this.add("North", j1);
        this.add("East", btn1);
        this.add("South", l1);
        btn1.setBackground(Color.green);
        l1.setSize(300, 100);

        this.add("Center", p1);
//        model.addElement("abc");

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btn1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            String idM = idf.getText();
            String nameM = namef.getText();
            String addrM = addrf.getText();

            model.addElement(idM+"/"+nameM);
            model.addElement(addrM);

            idf.setText("");
            namef.setText("");
            addrf.setText("");
        }
    }
}
