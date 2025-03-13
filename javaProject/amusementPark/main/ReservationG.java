package javaProject.amusementPark.main;

import javaProject.amusementPark.reservation.ReservationDAO;
import javaProject.amusementPark.reservation.ReservationDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

// 회원, 관리자 예약현황 둘다 전체 조회 삭제만 가능
public class ReservationG extends javax.swing.JFrame implements ActionListener {
    private JButton delete = new JButton("취소");
    private JTable table = null;
    public ReservationG() {
        setTitle("예약현황");
        setBounds(100, 100, 600, 300);
        table = getList();
        table.setBounds(0, 0, 600, 100);
        add(new JScrollPane(table));
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        delete.addActionListener(this);
        panel.add(delete);

        add("South", panel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public JTable getList() {
        ReservationDAO reservationDAO = new ReservationDAO();
        List<ReservationDTO> reservations = reservationDAO.selectAll();
        String[] header = {"예약번호", "회원 아이디", "이용권 번호", "놀이기구 번호", "예약시간"};
        String[][] data = new String[reservations.size()][header.length];
        for (int i = 0; i < reservations.size(); i++) {
            ReservationDTO reservation = reservations.get(i);
            data[i][0] = String.valueOf(reservation.getNo());
            data[i][1] = reservation.getMId();
            data[i][2] = reservation.getTPass();
            data[i][3] = reservation.getAtId();
            data[i][4] = reservation.toString(reservation.getRTime());
        }
        return new JTable(data, header);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == delete) {
            int row = table.getSelectedRow();
            if (row != -1) {
                ReservationDAO reservationDAO = new ReservationDAO();
                reservationDAO.delete(table.getValueAt(row, 0));
                dispose();
                new ReservationG();
            }
        }
    }
}
