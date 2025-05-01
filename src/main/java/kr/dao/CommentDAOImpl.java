package kr.dao;

import kr.VO.CommentVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CommentDAOImpl implements IF_CommentDAO{
    @Inject
    SqlSession sqlSession;

    @Override
    public int insertComment(CommentVO cvo) {
        return 0;
    }

    @Override
    public List<CommentVO> selectComments(int no) {
        List<CommentVO> comments = new ArrayList<>();
        return comments;
    }
}
