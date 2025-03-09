package school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
}
