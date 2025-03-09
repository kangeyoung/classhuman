package school;

import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TeacherDAO extends SuperDAO {

    TeacherDAO() throws ClassNotFoundException {
    }

    public void selectInfo(String tName) {
    }

    public boolean login(String id, String pass) throws SQLException {
        Connection conn = super.Connection();
        String sql = "select count(*) from teacher where tid = ? and tpass = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, id);
        ps.setString(2, pass);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) == 1;
        }
        return false;
    }

    public void add(TeacherDTO teacherDTO) throws SQLException {
        Connection conn = super.Connection();
        String sql = "insert into teacher values(?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, teacherDTO.getId());
        ps.setString(2, teacherDTO.getName());
        ps.setString(3, teacherDTO.getPass());
        ps.setInt(4, teacherDTO.getGenderNum());
        ps.setString(5, teacherDTO.getClassNum());
        ps.setString(6, teacherDTO.getTSubject());
        ps.setString(7, teacherDTO.getTPosition());
        int result = ps.executeUpdate();
        System.out.println(result+"건 추가 완료");
    }
}
