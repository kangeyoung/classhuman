package mar7.school;

import java.sql.*;

public class SuperDAO {
    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    String id = "system";
    String pass = "1111";
    Connection conn = null;

    SuperDAO() throws ClassNotFoundException {
        init();
    }

    private void init() throws ClassNotFoundException {
        Class.forName(driver);
        System.out.println("클래스 load");
    }

    public Connection Connection() throws SQLException {
        conn = DriverManager.getConnection(url, id, pass);
        System.out.println("연결성공");
        return conn;
    }

    public boolean selectId(int num, String id) throws SQLException {
        conn = Connection();
        String sql;
        if (num == 1) {
            sql = "select count(*) from student where sId = ?";
        } else {
            sql = "select count(*) from teacher where tId = ?";
        }
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) == 1;
        }
        return false;
    }
}
