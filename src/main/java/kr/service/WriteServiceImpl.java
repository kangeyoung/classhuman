package kr.service;

import kr.VO.WriteVO;
import kr.dao.IF_WriteDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class WriteServiceImpl implements IF_WriteService{
    @Inject
    IF_WriteDAO writeDAO;

    @Override
    public int insert(WriteVO wvo) {
        return 0;
    }

    @Override
    public List<WriteVO> select() {
        return null;
    }

    @Override
    public WriteVO selectOne(int id) {
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
