package kr.service;

import kr.VO.WriteVO;

import java.util.List;

public interface IF_WriteService {
    int insert(WriteVO wvo);
    List<WriteVO> select();
    WriteVO selectOne(int no);
    int update(WriteVO wvo);
    int delete(int no);
}
