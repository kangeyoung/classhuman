package school;

import lombok.NoArgsConstructor;

import java.sql.*;
import java.util.ArrayList;


public class StudentDAO extends SuperDAO {

    StudentDAO() throws ClassNotFoundException {
    }

    public ArrayList<StudentDTO> select() throws SQLException {
        Connection conn = super.Connection();
        ArrayList<StudentDTO> studentList = new ArrayList<>();
        String sql = "select * from student";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            String id = rs.getString("sid");
            String pass = rs.getString("spass");
            String name = rs.getString("sname");
            boolean gender = rs.getInt("sgender") == 1;
            String classname = rs.getString("class");
            String snum = rs.getString("snum");
            String score = rs.getString("sscore");
            StudentDTO studentDTO = new StudentDTO(id, pass, name, gender, classname, snum);
            studentDTO.setSScore(score);
            studentList.add(studentDTO);
        }
        return studentList;
    }

    public ArrayList<StudentDTO> select(int num, String text) throws SQLException {
        Connection conn = super.Connection();
        ArrayList<StudentDTO> studentList = new ArrayList<>();
        String sql = null;
        if (num == 1) {
            sql = "select * from student where sid = ?";
        }else{
            sql = "select * from student where CLASS = ?";
        }
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, text);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String id = rs.getString("sid");
            String pass = rs.getString("spass");
            String name = rs.getString("sname");
            boolean gender = rs.getInt("sgender") == 1;
            String classname = rs.getString("class");
            String snum = rs.getString("snum");
            String score = rs.getString("sscore");
            StudentDTO studentDTO = new StudentDTO(id, pass, name, gender, classname, snum);
            studentDTO.setSScore(score);
            studentList.add(studentDTO);
        }
        return studentList;
    }

    public boolean login(String id, String pass) throws SQLException {
        Connection conn = super.Connection();
        String sql = "select count(*) from student where sid = ? and spass = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, id);
        ps.setString(2, pass);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) == 1;
        }
        return false;
    }

    public void add(StudentDTO studentDTO) throws SQLException {
        Connection conn = super.Connection();
        String sql = "insert into student values(?,?,?,?,?,?,0)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, studentDTO.getId());
        ps.setString(2, studentDTO.getPass());
        ps.setString(3, studentDTO.getSNum());
        ps.setInt(4, studentDTO.getGenderNum());
        ps.setString(5, studentDTO.getClassNum());
        ps.setString(6, studentDTO.getSNum());
        int result = ps.executeUpdate();
        System.out.println(result + "건 추가 완료");
    }
}
