package kr.service;

import kr.VO.MemberVO;
import org.springframework.web.bind.annotation.RequestParam;

public interface IF_MemberService {
    int login(String id, String password);

    int insert(MemberVO mvo);

    int dupId(String id);

}
