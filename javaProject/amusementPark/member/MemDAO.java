package javaProject.amusementPark.member;

import javaProject.amusementPark.main.SuperDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemDAO extends SuperDAO {


    @Override
    public List<MemDTO> selectAll() {
        Connection conn = super.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<MemDTO> memberList = new ArrayList<>();
        String sql = "select * from member";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                MemDTO member = new MemDTO();
                member.setMId(rs.getString("mId"));
                member.setMName(rs.getString("mName"));
                member.setMPass(rs.getString("mPass"));
                member.setMGender(rs.getInt("mGender"));
                member.setMBirth(rs.getDate("mbirth"));
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

    public MemDTO select(String mId) {
        Connection conn = super.getConnection();
        String sql = "select * from member where mId = ?";
        ResultSet rs = null;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, mId);
            rs = stmt.executeQuery();
            if (rs.next()) {
                MemDTO member = new MemDTO();
                member.setMId(rs.getString("mId"));
                member.setMName(rs.getString("mName"));
                member.setMPass(rs.getString("mPass"));
                member.setMGender(rs.getInt("mGender"));
                member.setMBirth(rs.getDate("mBirth"));
                member.setTPass(rs.getString("tPass"));
                return member;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void edit(int num, String text, String mId) {
        String sql = null;
        switch (num) {
            case 1:
                sql = "update member set mPass = ? where mId = ?";
                break;
            case 2:
                sql = "update member set mName = ? where mId = ?";
                break;
            case 3:
                sql = "update member set mGender = ? where mId = ?";
                break;
            case 4:
                sql = "update member set mBirth = ? where mId = ?";
                break;
            default:
                break;
        }
        Connection conn = super.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            switch (num) {
                case 1:
                case 2:
                    pstmt.setString(1, text);
                    break;
                case 3:
                    pstmt.setInt(1, Integer.parseInt(text));
                    break;
                case 4:
                    pstmt.setDate(1, Date.valueOf(text));
                    break;
                default:
                    break;
            }
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


    public void update(MemDTO member) {
        Connection conn = super.getConnection();
        String sql = "update member set mPass = ?, mName = ?, mGender = ? ,mBirth = ?,tPass = ? where mId = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, member.getMPass());
            stmt.setString(2, member.getMName());
            stmt.setInt(3, member.getMGender());
            stmt.setDate(4, Date.valueOf(member.getMBirth().toString()));
            stmt.setString(5, member.getTPass());
            stmt.setString(6, member.getMId());
            int result = stmt.executeUpdate();
            System.out.println(result + "건 완료");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void delete(String mId) {
        Connection conn = super.getConnection();
        String sql = "delete from member where mId = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, mId);
            int result = stmt.executeUpdate();
            System.out.println(result + "건 완료");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean idPassDuplicate(int num, String id, String pw) {
        Connection conn = super.getConnection();
        String sql = null;
        switch (num) {
            case 1:
                sql = "select count(*) from administer where aId = ? and aPass = ?";
                break;
            case 2:
                sql = "select count(*) from member where mName = ? and mId = ?";
                break;
            default:
                break;
        }
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pw);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                if(rs.getInt(1) == 1) {
                    return true;
                }
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
        return false;
    }

    public boolean idDuplicate(String id) {
        Connection conn = super.getConnection();
        String sql = "select count(*) from member where mId = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                if(rs.getInt(1) == 1) {
                    return false;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public void insert(MemDTO memDTO) {
        Connection conn = super.getConnection();
        String sql = "insert into member values(?,?,?,?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memDTO.getMId());
            pstmt.setString(2, memDTO.getMPass());
            pstmt.setString(3, memDTO.getMName());
            pstmt.setInt(4, memDTO.getMGender());
            pstmt.setDate(5, Date.valueOf(memDTO.BirthToString()));
            pstmt.setString(6, memDTO.getTPass());
            int result = pstmt.executeUpdate();
            System.out.println(result+"건 완료");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
