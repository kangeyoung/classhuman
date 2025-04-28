package www.silver.hom;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MyController {

	@Resource(name="cname")
	String name;

	@RequestMapping(value="/", method= RequestMethod.GET)
//	@ResponseBody index의 원래 타입인 String으로 보내준다. 안 쓰면 jsp 파일의 이름으로 인식한다.
	public String home(Model model) {
		System.out.println("Name: " + name);
		return "index";
	}
	
	

}
