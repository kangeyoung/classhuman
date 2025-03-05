package Mar4.JDBC;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO {
    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    private String id = "system";
    private String pass = "1111";
    private Connection conn = null;
    private static UserDAO userDAO = null;

    public static UserDAO getInstance() {
        if (userDAO == null) {
            userDAO = new UserDAO();
        }
        return userDAO;
    }

    // DBMS주소: 포트번호: 데이터베이스 이름
    private UserDAO() {
        init();
    }

    private Connection getConnection() {
        try {
            conn = DriverManager.getConnection(url, id, pass);
            System.out.println("연결성공");
        } catch (SQLException e) {
            System.out.println("연결오류");
        }
        return conn;
    }

    private void init() {
        try { // 예외처리- 예외가 발생해도 정상 처리
            Class.forName(driver);
            // 라이브러리를 로드하는 의미.
            // 이 라이브러리는 오라클에 CRUD를 하기 위한 클래스들이 있음
            System.out.println("클래스 load 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("클래스 로드 실패");
            e.printStackTrace(); // 원인이 무엇인지 출력
        }
    }

    public void insert(UserDTO u) {
        String sql = "insert into user1 values(?,?)";
        PreparedStatement ps = null;
        try {
            if (getConnection() != null) {
                // CRUD 쿼리문 작성
                ps = conn.prepareStatement(sql);
                ps.setString(1, u.getName());
                ps.setString(2, u.getId());
                // 쿼리문 전송 & 결과값 받기
                int result = ps.executeUpdate();
                System.out.println(result + "건 삽입");
            }
        } catch (Exception e) {
        } finally {
            try {
                ps.close();
                conn.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<UserDTO> selectAll() {
        ArrayList<UserDTO> userList = new ArrayList<>();
        // 연결설정, 쿼리만들기, 매핑, 쿼리실행, 리턴값받기
        String sql = "select * from user1";
        Statement stmt = null;
        ResultSet rs = null;
        try {
            if (getConnection() != null) {
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    UserDTO user = new UserDTO();
                    user.setId(rs.getString("id"));
                    user.setName(rs.getString("name"));
                    userList.add(user);
                }
            }
        } catch (Exception e) {

        } finally {
            try {
                conn.close();
                stmt.close();
                rs.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return userList;
    }
}
