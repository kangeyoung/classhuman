package www.silver.hom;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import www.silver.VO.MemberVO;

@Controller
public class MemberjoinController {

    @RequestMapping(value="/memberjoin", method = RequestMethod.GET)
    public String memberjoin(Model model) {
        return "./member/memberjoinF";
    }
    @RequestMapping(value="/memberjoind", method = RequestMethod.POST)
    public String memberjoind(Model model, @ModelAttribute MemberVO membervo) {
        // vo로 받을 때 크라이언트의 변수명과 일치하면 자동 매핑
        System.out.println(membervo.getId()+"/"+membervo.getName());
        return "./member/memberjoinF";
    }
    @RequestMapping(value="/dupId", method = RequestMethod.GET)
    @ResponseBody
    public String dupId(Model model, @RequestParam("id") String id) {
        System.out.println("id: "+ id);
        return id;
    }
}
