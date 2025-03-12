package javaProject.amusementPark.member;

import javaProject.amusementPark.main.SuperDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MemDAO extends SuperDAO {
    public void login() {
        System.out.println("로그인성공");
    }

    public ArrayList<MemDTO> selectMem() {
        Connection conn = super.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<MemDTO> memberList = new ArrayList<>();
        String sql = "select * from member";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                MemDTO member = new MemDTO();
                member.setMId(rs.getString("mId"));
                member.setMName(rs.getString("mName"));
                member.setMPass(rs.getString("mPass"));
                member.setMGender(rs.getInt("mGender"));
                member.setMBirth(rs.getString("mbirth"));
                member.setTPass(rs.getString("tPass"));
                memberList.add(member);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return memberList;
    }

    public void updateMem(String mId) {
        System.out.println("수정할 부분 번호 입력");
        System.out.println("1. 회원 이름 2. 회원 성별 3. 회원 나이 4. 이용권 번호");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        String sql = null;
        switch (num) {
            case 1:
                sql = "update member set mName = ? where mId = ?";
                break;
            case 2:
                sql = "update member set mGender = ? where mId = ?";
                break;
            case 3:
                sql = "update member set mAge = ? where mId = ?";
                break;
            case 4:
                sql = "update member set tPass = ? where mId = ?";
                break;
            default:
                break;
        }
        Connection conn = super.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            System.out.println("수정할 내용 입력");
            pstmt.setString(1, sc.nextLine());
            pstmt.setString(2, mId);
            int result = pstmt.executeUpdate();
            System.out.println(result + "건 완료");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
