package kr.dao;

import kr.VO.CommentVO;

import java.util.List;

public interface IF_CommentDAO {
    int insertComment(CommentVO cvo);
    List<CommentVO> selectComments(int no);
}
