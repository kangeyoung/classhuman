package kr.service;

import kr.VO.CommentVO;
import kr.dao.CommentDAOImpl;

import java.util.List;

public interface IF_CommentService {
    int insertComment(CommentVO cvo);
    List<CommentVO> select(int no);
}
