package Mar4.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
}
