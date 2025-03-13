package javaProject.amusementPark.main;

import javaProject.amusementPark.member.MemDAO;
import javaProject.amusementPark.member.MemDTO;
import javaProject.amusementPark.reservation.ReservationDAO;
import javaProject.amusementPark.reservation.ReservationDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;

public class MemAdG extends javax.swing.JFrame implements ActionListener {
    private JButton edit = new JButton("수정");
    private JButton delete = new JButton("삭제");
    private JTable table = null;

    public MemAdG() {
        setTitle("회원관리");
        setBounds(100, 100, 600, 300);
        table = getList();
        table.setBounds(0, 0, 600, 100);
        add(new JScrollPane(table));
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        panel.add(edit);
        panel.add(delete);

        edit.addActionListener(this);
        delete.addActionListener(this);
        add("South", panel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private JTable getList() {
        MemDAO memDAO = new MemDAO();
        List<MemDTO> members = memDAO.selectAll();
        String[] header = {"아이디", "비밀번호", "이름", "성별", "생년월일", "이용권번호"};
        String[][] data = new String[members.size()][header.length];
        for (int i = 0; i < members.size(); i++) {
            MemDTO member = members.get(i);
            data[i][0] = member.getMId();
            data[i][1] = member.getMPass();
            data[i][2] = member.getMName();
            if (member.getMGender() == 0) {
                data[i][3] = "남자";
            } else {
                data[i][3] = "여자";
            }
            data[i][4] = member.toString(member.getMBirth());
            data[i][5] = member.getTPass();
        }
        return new JTable(data, header);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MemDAO memDAO = new MemDAO();
        MemDTO member = new MemDTO();
        int row = table.getSelectedRow();
        if (e.getSource() == edit) {
            System.out.println(table.getEditingRow());
            System.out.println(table.getEditingColumn());
            member.setMId(table.getValueAt(row, 0).toString());
            member.setMPass(table.getValueAt(row, 1).toString());
            member.setMName(table.getValueAt(row, 2).toString());
            if (table.getValueAt(row, 3).toString().equals("남자")) {
                member.setMGender(0);
            }else{
                member.setMGender(1);
            }
            member.setMBirth(Date.valueOf(table.getValueAt(row,4).toString()));
            member.setTPass(table.getValueAt(row,5).toString());
            memDAO.update(member);
            dispose();
            new MemAdG();
        }
        if (e.getSource() == delete) {
            String mId = table.getValueAt(row, 0).toString();
            memDAO.delete(mId);
            dispose();
            new MemAdG();
        }
    }
}
