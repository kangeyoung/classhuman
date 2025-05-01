package kr.service;

import kr.VO.CommentVO;
import kr.dao.IF_CommentDAO;
import kr.dao.IF_WriteDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements IF_CommentService {

    @Inject
    IF_CommentDAO commentDAO;

    @Override
    public int insertComment(CommentVO cvo) {
        return 0;
    }

    @Override
    public List<CommentVO> select(int no) {
        List<CommentVO> comments = new ArrayList<>();
        return comments;
    }
}
