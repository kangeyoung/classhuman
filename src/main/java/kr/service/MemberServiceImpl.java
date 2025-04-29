package kr.service;

import kr.VO.MemberVO;
import kr.dao.IF_MemberDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class MemberServiceImpl implements IF_memberService {
    @Inject
    IF_MemberDAO dao;

    @Override
    public void addUser(MemberVO membervo) {
        System.out.println(membervo.getTel() + "/" + membervo.getName());
        dao.insertMember(membervo);
    }

    @Override
    public MemberVO viewUser(String id) {
        return null;
    }
}
