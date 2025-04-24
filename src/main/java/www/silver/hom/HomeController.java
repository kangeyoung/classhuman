package www.silver.hom;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


/** aaa
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	String[][] tdata={{"서울","대전","부산","천안","대구"},
			{"새마을","무궁화","새마을","무궁화","새마을"},
			{"0910","0850","1000","1200","0945"},
			{"1010","1012","1520","1350","1300"}};

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model, @RequestParam(required = false,defaultValue = "-1")String d) {
		List<Train> trains = new ArrayList<Train>();
		String[] checkboxes = request.getParameterValues("int");

		if(checkboxes!=null) {
			for (int i = 0; i < checkboxes.length; i++) {
				int index = Integer.parseInt(checkboxes[i]);
				trains.add(new Train(tdata[0][index], tdata[1][index], tdata[2][index], tdata[3][index]));
			}
			model.addAttribute("trains", trains);
			return "home";
		}
		if(d.equals("-1")){
			for(int i=0;i<5;i++) {
				trains.add(new Train(tdata[0][i], tdata[1][i], tdata[2][i], tdata[3][i]));
			}
			model.addAttribute("trains", trains);
			return "home";
		}
		for (int i = 0; i< tdata[0].length; i++) {
			if(d.equals(tdata[0][i])){
				trains.add(new Train(tdata[0][i],tdata[1][i],tdata[2][i],tdata[3][i]));
				model.addAttribute("trains", trains);
				break;
			}
		}
		return "home";
	}
	@RequestMapping(value = "/base", method = RequestMethod.GET)
	public String base() {
		return "base";
	}

	@RequestMapping(value = "/foodmenu", method = RequestMethod.GET)
	public String foodmenu(Model model) {
		List<Meals>foodlist = new ArrayList<Meals>();
		foodlist.add(new Meals("쌀밥", "떡국", "닭볶음탕"));
		foodlist.add(new Meals("잡곡밥", "오징어국", "불고기"));
		foodlist.add(new Meals("현미밥", "김치국", "만두"));
		foodlist.add(new Meals("쌀밥", "육개장", "돈가스"));
		foodlist.add(new Meals("쌀밥", "된장국", "돼지두루치기"));

		model.addAttribute("foodlist", foodlist);



		return "foodmenu";
	}
	//https://bubblecastle.tistory.com/9
	
}
