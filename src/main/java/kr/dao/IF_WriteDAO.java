package kr.dao;

import kr.VO.WriteVO;

import java.util.List;

public interface IF_WriteDAO {
    int insert(WriteVO wvo);
    List<WriteVO> select();
    WriteVO selectOne(int no);
    int update(WriteVO wvo);
    int delete(int no);
}
