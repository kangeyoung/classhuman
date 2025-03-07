package mar4.book;

import java.sql.*;

public class UserDAO {
    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:orcl";

    UserDAO() {
        init();
    }

    private Connection connection() {
        try {
            return DriverManager.getConnection(url, "system", "1111");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void init() {
        try {
            Class.forName(driver);
            System.out.println("클래스 Load 성공");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void insert(User user) {
        Connection conn = connection();
        String sql = "insert into userlist values(?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUname());
            ps.setString(2, user.getUide());
            ps.setInt(3,user.getBnum());
            int result= ps.executeUpdate();
            System.out.println(result+"건 완료");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int searchuname(String uname) {
        Connection conn = connection();
        String sql = "select count(*) from userlist where uname=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, uname);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int result= rs.getInt(1);
                return result;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
