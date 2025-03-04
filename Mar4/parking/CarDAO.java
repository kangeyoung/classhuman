package Mar4.parking;


import java.sql.*;
import java.util.ArrayList;

public class CarDAO {
    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:orcl";

    CarDAO() {
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

    public void insert(CarDTO car) {
        Connection conn = connection();
        String sql = "insert into car values(?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, car.getCarnum());
            ps.setString(2, car.getCaruser());
            ps.setInt(3, car.getParking());
            int result = ps.executeUpdate();
            System.out.println(result + "건 삽입");
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<CarDTO> selectAll()  {
        Connection conn = connection();
        ArrayList<CarDTO> carList = new ArrayList<>();
        String sql = "select * from car order by parkingnum";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                CarDTO car = new CarDTO();
                car.setCarnum(rs.getString("carnum"));
                car.setCaruser(rs.getString("caruser"));
                car.setParking(rs.getInt("parkingnum"));
                carList.add(car);
            }
            return carList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public CarDTO select(String carnum) {
        Connection conn = connection();
        CarDTO car = new CarDTO();
        String sql = "select * from car where carnum=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, carnum);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                car.setCarnum(rs.getString("carnum"));
                car.setCaruser(rs.getString("caruser"));
                car.setParking(rs.getInt("parkingnum"));
            }
            return car;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(String carnum, CarDTO car) {
        Connection conn = connection();
        String sql = "update car set carnum=?,caruser=?,parkingnum=? where carnum=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, car.getCarnum());
            ps.setString(2, car.getCaruser());
            ps.setInt(3, car.getParking());
            ps.setString(4, carnum);
            int result = ps.executeUpdate();
            System.out.println(result + "건 수정 완료");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(CarDTO car) {
        Connection conn = connection();
        String sql = "delete from car where carnum=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, car.getCarnum());
            int result = ps.executeUpdate();
            System.out.println(result + "건 삭제 완료");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int selectCarnum(String carnum) {
        Connection conn = connection();
        String sql = "select count(*) from car where carnum=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, carnum);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public int selectParking(int parkingnum) {
        Connection conn = connection();
        String sql = "select count(*) from car where parkingnum=?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, parkingnum);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return 0;
    }

}
