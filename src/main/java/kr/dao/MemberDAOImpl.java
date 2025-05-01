package kr.dao;

import kr.VO.MemberVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Repository
public class MemberDAOImpl implements IF_MemberDAO {
    @Inject
    SqlSession sqlSession;

    @Override
    public MemberVO login(String id, String pass) {
        HashMap<String, String> map = new HashMap<>();
        map.put("id", id);
        map.put("pass", pass);
        MemberVO mvo = sqlSession.selectOne("kr.dao.IF_MemberDAO.login", map);
        return mvo;
    }

    @Override
    public int insertMember(MemberVO mvo) {
        int suc = sqlSession.insert("kr.dao.IF_MemberDAO.insertOne", mvo);
        System.out.println(suc);
        return suc;
    }

    @Override
    public MemberVO selectId(String id) {
        MemberVO mvo = sqlSession.selectOne("kr.dao.IF_MemberDAO.selectId", id);
        return mvo;
    }
}
