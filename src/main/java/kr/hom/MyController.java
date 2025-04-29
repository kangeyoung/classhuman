package kr.hom;

import kr.VO.MemberVO;
import kr.service.IF_memberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
public class MyController {

    @Inject
    IF_memberService memberService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
    @RequestMapping(value="/memberjoin", method = RequestMethod.GET)
    public String memberjoin(Model model) {
        return "./member/memberjoinF";
    }
    @RequestMapping(value="/memberjoind", method = RequestMethod.POST)
    public String memberjoind(Model model, @ModelAttribute MemberVO membervo) {
        // vo로 받을 때 클라이언트의 변수명과 일치하면 자동 매핑
        System.out.println(membervo.getId()+"/"+membervo.getName());
        memberService.addUser(membervo);
        return "./member/memberjoinF";
    }
    @RequestMapping(value="/dupId", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String dupId(Model model, @RequestParam("id") String id) throws UnsupportedEncodingException {
        // 응답 인코딩 설정
        System.out.println("1"+id);
        String encoded = URLEncoder.encode(id, StandardCharsets.UTF_8.toString());
        System.out.println("2"+encoded);
        String decoded = URLDecoder.decode(id, StandardCharsets.UTF_8.name());
        // 디코딩 시도
        System.out.println("3"+decoded);

        // 디코딩된 값을 반환
        return id;
    }
}
