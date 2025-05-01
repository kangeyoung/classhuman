package kr.dao;

import kr.VO.MemberVO;

public interface IF_MemberDAO {
    MemberVO login(String id, String password);
    int insertMember(MemberVO mvo);
    MemberVO selectId(String id);
}
