package amusementPark;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SuperDAO {
    String driver = "org.mariadb.jdbc.Driver";
    String url = "jdbc:mariadb://localhost:3306/mysql";
    String user = "root";
    String password = "1111";
    Connection conn = null;

    SuperDAO() {
        init();
    }

    private void init() {
        try {
            Class.forName(driver);
            System.out.println("클래스 load");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        try {
            conn = DriverManager.getConnection(url,user,password);
            System.out.println("연결 성공");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

}
