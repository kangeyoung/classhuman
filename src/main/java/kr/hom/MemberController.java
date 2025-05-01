package kr.hom;

import kr.VO.MemberVO;
import kr.service.MemberServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@Controller
public class MemberController {
    @Inject
    MemberServiceImpl memberService;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "member/login";
    }

    @RequestMapping(value="/loginIn", method = RequestMethod.POST)
    public String loginIn(Model model, @RequestParam String id, @RequestParam String pass) {
        System.out.println(id);
        int login = memberService.login(id, pass); // 로그인 성공 시 1 실패 시 0
        if (login == 1){
            return "redirect:/write";
        }else{
            model.addAttribute("login", "실패>회원가입");
            return "member/login";
        }
    }

    @RequestMapping(value="/signUp", method = RequestMethod.POST)
    public String signUp(Model model, @ModelAttribute MemberVO mvo) {
        System.out.println(mvo.getId());
        int insert = memberService.insert(mvo);
        return "member/login";
    }
}
