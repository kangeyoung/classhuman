package javaProject.amusementPark.main;

import javaProject.amusementPark.member.MemDAO;
import javaProject.amusementPark.member.MemDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

// 회원 회원정보수정
public class MemG extends JFrame implements ActionListener {
    private JPanel labelJPanel = new JPanel();
    private String[] labelName = {"아이디", "비밀번호", "이름", "성별", "생년월일", "이용권번호"};
    private JPanel textFJPanel = new JPanel();
    private JRadioButton radioMan = new JRadioButton("남자");
    private JRadioButton radioWoman = new JRadioButton("여자");
    private JComboBox yearCom;
    private JComboBox monthCom;
    private JComboBox dayCom;
    private JButton editPass = new JButton("수정");
    private JButton editName = new JButton("수정");
    private JButton editGender = new JButton("수정");
    private JButton editBirth = new JButton("수정");
    private JPanel buttonJPanel = new JPanel();
    private JLabel mId = new JLabel();
    private JTextField mPass = new JTextField();
    private JTextField mName = new JTextField();

    public MemG() {
        setTitle("회원정보");
        setBounds(10, 10, 400, 300);
        setLayout(null);

        setLabelJPanel();
        labelJPanel.setBounds(10, 10, 80, 200);
        add(labelJPanel);

        setTextFieldsJPanel();
        textFJPanel.setBounds(100, 10, 210, 200);
        add(textFJPanel);

        setButtonJPanel();
        buttonJPanel.setBounds(310, 10, 60, 200);
        add(buttonJPanel);

        editPass.addActionListener(this);
        editName.addActionListener(this);
        editGender.addActionListener(this);
        editBirth.addActionListener(this);

        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void setButtonJPanel() {
        GridLayout a = new GridLayout(6, 1);
        a.setVgap(2);
        buttonJPanel.setLayout(a);
        buttonJPanel.add(new JLabel(""));
        buttonJPanel.add(editPass);
        buttonJPanel.add(editName);
        buttonJPanel.add(editGender);
        buttonJPanel.add(editBirth);
        buttonJPanel.add(new JLabel(""));
    }

    private void setTextFieldsJPanel() { // 테스트용 id = "M1001"
        textFJPanel.setLayout(new GridLayout(6, 1));
        MemDAO memDAO = new MemDAO();
        MemDTO memDTO = memDAO.select("M1002");
        mId = new JLabel(memDTO.getMId());
        textFJPanel.add(mId);
        mPass = new JTextField(memDTO.getMPass(), 10);
        mPass.setSize(150, 20);
        mPass.setEditable(true);
        textFJPanel.add(mPass);
        mName = new JTextField(memDTO.getMName(), 10);
        mName.setSize(150, 20);
        mName.setEditable(true);
        textFJPanel.add(mName);
        JPanel mGender = makeGenderPanel(memDTO.getMGender());
        textFJPanel.add(mGender);
        JPanel mBirth = makerBirthPanel(memDTO);
        textFJPanel.add(mBirth);
        JLabel tPass = new JLabel(memDTO.getTPass());
        textFJPanel.add(tPass);

    }

    private void setLabelJPanel() {
        labelJPanel.setLayout(new GridLayout(6, 1));
        for (int i = 0; i < labelName.length; i++) {
            StringBuilder labelN = new StringBuilder(labelName[i]);
            while (labelN.length() < 5) {
                labelN.append(" ");
            }
            JLabel label = new JLabel(labelN.toString());
            labelJPanel.add(label);

        }
    }

    private JPanel makeGenderPanel(int a) {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(radioMan);
        panel.add(radioWoman);
        if (a == 0) {
            radioMan.setSelected(true);
        } else if (a == 1) {
            radioWoman.setSelected(true);
        }
        radioMan.addActionListener(actionEvent -> {
            if (radioMan.isSelected()) {
                radioWoman.setSelected(false);
            } else {
                radioMan.setSelected(true);
            }
        });
        radioWoman.addActionListener(actionEvent -> {
            if (radioWoman.isSelected()) {
                radioMan.setSelected(false);
            } else {
                radioWoman.setSelected(true);
            }
        });
        return panel;
    }

    private JPanel makerBirthPanel(MemDTO memDTO) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        String[] year = new String[46];
        String[] month = new String[12];
        String[] day = new String[31];
        for (int i = 0; i < year.length; i++) {
            year[i] = String.valueOf(i + 1980);
        }
        for (int i = 0; i < month.length; i++) {
            month[i] = String.valueOf(i + 1);
        }
        for (int i = 0; i < day.length; i++) {
            day[i] = String.valueOf(i + 1);
        }
        yearCom = new JComboBox(year);
        yearCom.setBackground(Color.WHITE);
        monthCom = new JComboBox(month);
        monthCom.setBackground(Color.WHITE);
        dayCom = new JComboBox(day);
        dayCom.setBackground(Color.WHITE);
        panel.add(yearCom);
        panel.add(new JLabel("년"));
        panel.add(monthCom);
        panel.add(new JLabel("월"));
        panel.add(dayCom);
        panel.add(new JLabel("일"));

        int mBYear = Integer.parseInt(memDTO.getYear());
        int mBMonth = Integer.parseInt(memDTO.getMonth());
        int mBDay = Integer.parseInt(memDTO.getDay());

        yearCom.setSelectedIndex(mBYear - 1980);
        monthCom.setSelectedIndex(mBMonth - 1);
        dayCom.setSelectedIndex(mBDay - 1);

        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MemDAO memDAO = new MemDAO();
        String newId = mId.getText();
        if (e.getSource() == editPass) {
            String newPass = mPass.getText();
            memDAO.edit(1, newPass, newId);
            dispose();
            new MemG();
        }
        if (e.getSource() == editName) {
            String newName = mName.getText();
            memDAO.edit(2, newName,newId);
            dispose();
            new MemG();
        }
        if (e.getSource() == editGender) {
            if (radioMan.isSelected()) {
                memDAO.edit(3, "0", newId);
            } else {
                memDAO.edit(3, "1", newId);
            }
            dispose();
            new MemG();
        }
        if (e.getSource() == editBirth) {
            String newBirth = yearCom.getSelectedItem().toString() + "-" + monthCom.getSelectedItem().toString() + "-" + dayCom.getSelectedItem().toString();
            System.out.println(newBirth);
            memDAO.edit(4, newBirth, newId);
            dispose();
            new MemG();
        }
    }
}
