package www.silver.hom;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class WeatherController {
    WeatherService wS = new WeatherService();

    @RequestMapping(value = "/wt", method = RequestMethod.GET)
    public String mainP(HttpServletRequest request, Model model, @RequestParam(required = false, defaultValue = "0") String city) {
        String[] checkes = request.getParameterValues("searCheck");
        if (checkes != null) {
            System.out.println(checkes[0]);
            List<WeatherDTO> list = wS.selectInfo(checkes);
            model.addAttribute("list", list);
            return "wt";
        } else if (city.equals("0")) {
            return "wt";
        }
        List<WeatherDTO> list = wS.selectInfo(city);
        model.addAttribute("list", list);
        return "wt";
    }

}
