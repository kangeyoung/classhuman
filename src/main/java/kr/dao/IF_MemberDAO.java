package kr.dao;

import kr.VO.MemberVO;

public interface IF_MemberDAO {
    int login(String id, String password);
    int insertMember(MemberVO mvo);

}
