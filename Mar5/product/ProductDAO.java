package Mar5.product;

import java.sql.*;
import java.util.ArrayList;

public class ProductDAO {
    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    private String id = "system";
    private String pass = "1111";
    private static ProductDAO productDAO;

    public static ProductDAO getInstance() throws ClassNotFoundException {
        if (productDAO == null) {
            productDAO = new ProductDAO();
        }
        return productDAO;
    }

    private ProductDAO() throws ClassNotFoundException {
        init();
    }

    private void init() throws ClassNotFoundException {
        Class.forName(driver);
        System.out.println("클래스 load");
    }

    public int count() throws SQLException {
        Connection conn = DriverManager.getConnection(url, id, pass);
        String sql = "select count(*) from product";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()) {
            return rs.getInt(1);
        }
        stmt.close();
        conn.close();
        return 0;
    }

    public void add(ProductDTO productDTO) throws SQLException {
        String sql = "insert into product values(?,?,?,?,?,?,?,default)";
        Connection conn = DriverManager.getConnection(url, id, pass);
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, productDTO.getId());
        pstmt.setString(2, productDTO.getName());
        pstmt.setString(3, productDTO.getQuantity());
        pstmt.setString(4, productDTO.getPrice());
        pstmt.setString(5, productDTO.getType());
        pstmt.setString(6, productDTO.getManager());
        pstmt.setString(7, productDTO.getDescription());
        int result = pstmt.executeUpdate();
        if (result == 1) {
            System.out.println(result + "건 product 테이블에 저장 완료");
        }
        pstmt.close();
        conn.close();
    }

    public ArrayList<ProductDTO> select(int i, String text) throws SQLException {
        ArrayList<ProductDTO> productList = new ArrayList<>();
        String sql;
        switch (i) {
            case 1:
                sql = "select * from product order by id";
                break;
            case 2:
                sql = "select * from product where name like ? or description like ?";
                break;
            case 3:
                sql = "select * from product where type = ?";
                break;
            default:
                System.out.println("오류");
                return null;
        }
        Connection conn = DriverManager.getConnection(url, id, pass);
        ResultSet rs = null;
        switch (i) {
            case 1:
                Statement stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                break;
            case 2:
            case 3:
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, text);
                pstmt.setString(2, text);
                rs = pstmt.executeQuery();
                break;
            default:
                System.out.println("오류");
                return null;
        }
        while (rs.next()) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(rs.getString("id"));
            productDTO.setName(rs.getString("name"));
            productDTO.setQuantity(rs.getString("quantity"));
            productDTO.setPrice(rs.getString("price"));
            productDTO.setType(rs.getString("type"));
            productDTO.setManager(rs.getString("manager"));
            productDTO.setDescription(rs.getString("description"));
            productDTO.setDate(rs.getString("indate"));
            productList.add(productDTO);
        }
        rs.close();
        conn.close();
        return productList;
    }

    public void delete(String name) throws SQLException {
        String sql = "delete from product where name = ?";
        Connection conn = DriverManager.getConnection(url, id, pass);
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        int result = pstmt.executeUpdate();
        if (result == 1) {
            System.out.println(result + "건 삭제 완료");
        }
        pstmt.close();
        conn.close();
    }

    public void change(int cho, String text, String name) throws SQLException {
        String sql;
        switch (cho) {
            case 1:
                sql = "update product set quantity = ? where name = ?";
                break;
            case 2:
                sql = "update product set price = ? where name = ?";
                break;
            case 3:
                sql = "update product set type = ? where name = ?";
                break;
            case 4:
                sql = "update product set manager = ? where name = ?";
                break;
            case 5:
                sql = "update product set description = ? where name = ?";
                break;
            default:
                System.out.println("오류");
                return;
        }
        Connection conn = DriverManager.getConnection(url, id, pass);
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, text);
        pstmt.setString(2, name);
        int result = pstmt.executeUpdate();
        if (result == 1) {
            System.out.println(result + "건 수정 완료");
        }
        pstmt.close();
        conn.close();
    }
}
