package kr.service;

import kr.VO.MemberVO;
import kr.dao.IF_MemberDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class MemberServiceImpl implements IF_MemberService {
    @Inject
    IF_MemberDAO memberDAO;

    @Override
    public int login(String id, String pass) {
        MemberVO mvo = memberDAO.login(id, pass);
        if (mvo != null) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int insert(MemberVO mvo) {
        System.out.println("service");
        return memberDAO.insertMember(mvo);
    }

    @Override
    public int dupId(String id) {
        MemberVO mvo = memberDAO.selectId(id);
        if (mvo != null) {
            return 1;
        } else {
            return 0;
        }
    }
}
