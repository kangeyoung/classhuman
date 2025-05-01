package kr.dao;

import kr.VO.MemberVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberDAOImpl implements IF_MemberDAO {
    @Inject
    SqlSession sqlSession;

    @Override
    public int login(String id, String pass) {
        HashMap<String, String> map = new HashMap<>();
        map.put("id", id);
        map.put("pass", pass);
        MemberVO memberVO = sqlSession.selectOne("kr.dao.IF_MemberDAO.login", map);
        if (memberVO != null) { // 로그인 성공
            System.out.println(memberVO.getId());
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int insertMember(MemberVO mvo) {
        int suc =sqlSession.insert("kr.dao.IF_MemberDAO.insertOne", mvo);
        System.out.println(suc);
        return suc;
    }
}
