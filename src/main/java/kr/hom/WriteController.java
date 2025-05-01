package kr.hom;

import kr.VO.MemberVO;
import kr.service.IF_CommentService;
import kr.service.IF_WriteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

@Controller
public class WriteController {
    @Inject
    IF_WriteService writeService;

    @Inject
    IF_CommentService commentService;

    @RequestMapping(value="/write", method = RequestMethod.GET)
    public String write(Model model, @ModelAttribute MemberVO mvo) {

        return "write/write";
    }
}
