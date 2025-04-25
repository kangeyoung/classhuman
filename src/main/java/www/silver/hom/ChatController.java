package www.silver.hom;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ChatController {
    ChatService cS = new ChatService();

    @RequestMapping(value = "/chat/startC", method = RequestMethod.GET)
    public String startC(HttpServletRequest request, Model model, @RequestParam(required = false) String nickName,
                         @RequestParam(required = false) String sTime) {
        System.out.println(nickName);
        System.out.println(sTime);
        if (nickName != null) {
            int sTimeInt = Integer.parseInt(sTime);
            System.out.println(nickName);
            if (cS.addUser(nickName, sTimeInt)) {
                model.addAttribute("nicky", nickName);
                return "redirect:/chat/chat";
            }
        }
        System.out.println(2);
        return "chat/startC";
    }
    @RequestMapping(value="/chat/chat", method = RequestMethod.GET)
    public String chat(HttpServletRequest request, Model model) {
        String nickName = request.getParameter("nicky");
        System.out.println(nickName);
        String timeString = request.getParameter("timeString");
        System.out.println(timeString);
        String msgText = request.getParameter("msgText");
        String mmm = request.getParameter("mmm");
        model.addAttribute("mmm", mmm);
        List<String> msgList=new ArrayList<>();
        if(nickName != null) {
            if(timeString != null) {
                int sTimeInt = Integer.parseInt(timeString);
                cS.addMsg(nickName, sTimeInt, msgText);
            }
            msgList=cS.printMsg(nickName);
        }
        model.addAttribute("msgList", msgList);
        return "/chat/chat";
    }
}

