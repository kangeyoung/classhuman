package Mar4.JDBC;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO {
    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
                                        // DBMS주소: 포트번호: 데이터베이스 이름
    UserDAO(){
        init();
    }

    private void init() {
        try { // 예외처리- 예외가 발생해도 정상 처리
            Class.forName(driver);
            // 라이브러리를 로드하는 의미.
            // 이 라이브러리는 오라클에 CRUD를 하기 위한 클래스들이 있음
            System.out.println("클래스 load 성공");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insert(UserDTO u) {
        try {
            // connection
            Connection conn = DriverManager.getConnection(url, "system", "1111");
            System.out.println("연결성공");
            // CRUD 쿼리문 작성
            String sql = "insert into user1 values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, u.getName());
            ps.setString(2,u.getId());
            // 쿼리문 전송 & 결과값 받기
            int result = ps.executeUpdate();
            System.out.println(result+"건 삽입");
            // 연결해제-자원반납
            ps.close();
            conn.close();

        }catch (Exception e) {
        }
    }

    public ArrayList<UserDTO> selectAll() {
        ArrayList<UserDTO> userList = new ArrayList<>();
        // 연결설정, 쿼리만들기, 매핑, 쿼리실행, 리턴값받기
        try {
            Connection conn = DriverManager.getConnection(url, "system", "1111");
            System.out.println("연결 성공");
            String sql = "select * from user1";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                UserDTO user = new UserDTO();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                userList.add(user);
            }
        }catch (Exception e) {

        }
        return userList;
    }
}
