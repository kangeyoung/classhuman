package Mar4.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDAO {
    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:orcl";

    BookDAO() {
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

    public void insert(Book book) {
        Connection conn = connection();
        String sql = "insert into booklist values(?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, book.getUname());
            ps.setString(2, book.getBname());
            ps.setString(3, book.getBdate());
            int result = ps.executeUpdate();
            System.out.println(result + "건 완료");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String sql2 = "update userlist set bnum = bnum+1 where uname =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql2);
            ps.setString(1, book.getUname());
            int result = ps.executeUpdate();
            System.out.println(result + "건 완료");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
