package amusementPark;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminDAO extends SuperDAO {
    public ArrayList<MemberDTO> selectMem() {
        Connection conn = super.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<MemberDTO> memberList = new ArrayList<>();
        String sql = "select * from member";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                MemberDTO member = new MemberDTO();
                member.setSId(rs.getString("sId"));
                member.setSName(rs.getString("sName"));
                member.setSPass(rs.getString("sPass"));
                member.setSGender(rs.getInt("sGender") == 1);
                member.setSAge(rs.getInt("sAge"));
                member.setFPass(rs.getString("fPass"));
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

    public void updateMem(String sId) {
        System.out.println("수정할 부분 번호 입력");
        System.out.println("1. 회원 이름 2. 회원 성별 3. 회원 나이 4. 이용권 번호");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        String sql = null;
        switch (num) {
            case 1:
                sql = "update member set sName = ? where sId = ?";
                break;
            case 2:
                sql = "update member set sGender = ? where sId = ?";
                break;
            case 3:
                sql = "update member set sAge = ? where sId = ?";
                break;
            case 4:
                sql = "update member set fPass = ? where sId = ?";
                break;
            default:
                break;
        }
        Connection conn = super.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            System.out.println("수정할 내용 입력");
            pstmt.setString(1, sc.nextLine());
            pstmt.setString(2, sId);
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

    public void deleteMem(String sId) {
        Connection conn = super.getConnection();
        String sql = "delete from member where sId = ?";
        try {
            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate(sql);
            System.out.println(result + "건 완료");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<ReservationDTO> selectRes() {
        Connection conn = super.getConnection();
        String sql = "select * from reservation";
        ResultSet rs = null;
        ArrayList<ReservationDTO> reservationList = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                ReservationDTO reservation = new ReservationDTO();
                reservation.setNo(rs.getInt("no"));
                reservation.setSId(rs.getString("sId"));
                reservation.setFPass(rs.getString("fPass"));
                reservation.setRRide(rs.getString("rRide"));
                reservation.setRDate(rs.getString("rDate"));
                reservationList.add(reservation);
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

        return reservationList;
    }

    public void deleteRes(int no) {
        Connection conn = super.getConnection();
        String sql = "delete from reservation where no = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, no);
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


    public void updateAdm(String id) {
        System.out.println("수정할 부분 번호 입력");
        System.out.println("1. 이름 2. 성별 3. 나이 4. 직책");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String sql = null;
        switch (num) {
            case 1:
                sql = "update administer set aName = ? where aId = ?";
                break;
            case 2:
                sql = "update administer set aGender = ? where aId = ?";
                break;
            case 3:
                sql = "update administer set aAge = ? where aId = ?";
                break;
            case 4:
                sql = "update administer set aPosition  = ? where aId = ?";
                break;
            default:
                break;
        }
        Connection conn = super.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            System.out.println("수정할 내용 입력");
            pstmt.setString(1, sc.nextLine());
            pstmt.setString(2, id);
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

    public void deleteAdm(String id) {
        Connection conn = super.getConnection();
        String sql = "delete from administer where aId = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
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
