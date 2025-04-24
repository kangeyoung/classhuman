package www.silver.hom;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class WeatherController {
    WeatherService wS = new WeatherService();

    @RequestMapping(value = "/wt", method = RequestMethod.GET)
    public String mainP(HttpServletRequest request, Model model, @RequestParam(required = false, defaultValue = "0") String city) {
        String[] checkes = request.getParameterValues("searCheck");
        String[] deletes = request.getParameterValues("delCheck");
        if (checkes != null) {
            System.out.println(checkes[0]);
            List<WeatherDTO> list = wS.selectInfo(checkes);
            model.addAttribute("list", list);
            return "wt";
        } else if (deletes != null) {
            wS.deleteInfo(deletes);
            System.out.println("200");
            return "wt";
        } else if (city.equals("0")||city.isEmpty()) {
            return "wt";
        }
        List<WeatherDTO> list = wS.selectInfo(city);
        model.addAttribute("list", list);
        return "wt";
    }

    @RequestMapping(value = "/addUp", method = RequestMethod.GET)
    public String add(HttpServletRequest request) {
        String city = request.getParameter("city");
        String weather = request.getParameter("weather");
        int maxT= Integer.parseInt(request.getParameter("maxT"));
        int minT= Integer.parseInt(request.getParameter("minT"));
        WeatherDTO weatherInfo = new WeatherDTO(city,maxT,minT,weather);
        wS.addInfo(weatherInfo);
        StringBuilder sb = new StringBuilder("redirect:/wt?city=");
        sb.append(URLEncoder.encode(weatherInfo.getCity(), StandardCharsets.UTF_8));
        return sb.toString();
    }
}
