package kr.dao;

import kr.VO.MemberVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository
public class MemberDAOImpl implements IF_MemberDAO{

    @Inject
    private SqlSession sqlSession;

    @Override
    public void insertMember(MemberVO membervo) {
        System.out.println(membervo.getTel());
        sqlSession.insert("kr.dao.IF_MemberDAO.insertOne", membervo);
    }
}
