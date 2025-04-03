package javaProject.amusementPark.administer;

import javaProject.amusementPark.main.SuperDAO;
import javaProject.amusementPark.administer.AdminDTO;

import java.sql.*;

public class AdminDAO extends SuperDAO {
    public boolean idDuplicate(String id) {
        Connection conn = super.getConnection();
        String sql = "select count(*) from administer where aId = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                if (rs.getInt(1) == 1) {
                    return false;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public void insert(AdminDTO adminDTO) {
        Connection conn = super.getConnection();
        String sql = "insert into administer values(?,?,?,?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, adminDTO.getAId());
            pstmt.setString(2, adminDTO.getAPass());
            pstmt.setString(3, adminDTO.getAName());
            pstmt.setInt(4, adminDTO.getAGender());
            pstmt.setDate(5, Date.valueOf(adminDTO.BirthToString()));
            pstmt.setString(6, adminDTO.getAPosition());
            int result = pstmt.executeUpdate();
            System.out.println(result+"건 완료");
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
