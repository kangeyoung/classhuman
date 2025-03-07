package mar7.school;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TeacherDAO extends SuperDAO {
    TeacherDAO() throws ClassNotFoundException {
    }

    public boolean login(String id, String pass) {
        return false;
    }

    public void selectInfo(String tName) {
    }

    public boolean selecttName(String tName) {

        return false;
    }

    public void delete(String tName) {
    }

    public void update(int cho, String text, String sName) {
    }

    public void insert(TeacherDTO teacherDTO) throws SQLException {
        Connection conn = super.Connection();
        String sql = "insert into teacher values(?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, teacherDTO.id);
        ps.setString(2, teacherDTO.pass);
        ps.setString(3, teacherDTO.name);
        ps.setString(4, teacherDTO.getGender());
        ps.setString(5, teacherDTO.className);
        ps.setString(6, teacherDTO.tSubject);
    }
}
