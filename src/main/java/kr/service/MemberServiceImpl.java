package kr.service;

import kr.VO.MemberVO;
import kr.dao.IF_MemberDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class MemberServiceImpl implements IF_MemberService{
    @Inject
    IF_MemberDAO memberDAO;

    @Override
    public int login(String id, String pass) {
        return memberDAO.login(id, pass);
    }

    @Override
    public int insert(MemberVO mvo) {
        System.out.println("service");
        return memberDAO.insertMember(mvo);
    }
}
