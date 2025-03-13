package javaProject.amusementPark.reservation;

import javaProject.amusementPark.main.SuperDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO extends SuperDAO {


    @Override
    public List<ReservationDTO> selectAll() {
        List<ReservationDTO> reservations = new ArrayList<>();
        String sql = "select * from reservation";
        Connection conn = super.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ReservationDTO reservation = new ReservationDTO();
                reservation.setNo(rs.getInt("no"));
                reservation.setMId(rs.getString("mId"));
                reservation.setTPass(rs.getString("tPass"));
                reservation.setAtId(rs.getString("atId"));
                reservation.setRTime(rs.getDate("rTime"));
                reservations.add(reservation);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return reservations;
    }


    public void delete(Object o) {
        Connection conn = super.getConnection();
        String sql = "delete from reservation where no = ?";
        int intNo = Integer.parseInt(o.toString());
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, intNo);
            int result = stmt.executeUpdate();
            System.out.println(result + "건 완료");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}



