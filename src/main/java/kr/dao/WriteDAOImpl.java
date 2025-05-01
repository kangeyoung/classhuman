package kr.dao;

import kr.VO.WriteVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class WriteDAOImpl implements IF_WriteDAO{
    @Inject
    SqlSession sqlSession;

    @Override
    public int insert(WriteVO wvo) {
        return 0;
    }

    @Override
    public List<WriteVO> select() {
        return null;
    }

    @Override
    public WriteVO selectOne(int no) {
        return null;
    }

    @Override
    public int update(WriteVO wvo) {
        return 0;
    }

    @Override
    public int delete(int no) {
        return 0;
    }
}
