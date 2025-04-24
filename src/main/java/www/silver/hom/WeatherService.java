package www.silver.hom;

import java.util.ArrayList;
import java.util.List;

public class WeatherService {
    private List<WeatherDTO> weatherDTOList = new ArrayList<>();

    public WeatherService() {
        weatherDTOList.add(new WeatherDTO("서울특별시", 25, 8, "맑음"));
        weatherDTOList.add(new WeatherDTO("부산광역시", 25, 8, "맑음"));
        weatherDTOList.add(new WeatherDTO("대구광역시", 25, 8, "맑음"));
        weatherDTOList.add(new WeatherDTO("인천광역시", 25, 8, "맑음"));
        weatherDTOList.add(new WeatherDTO("광주광역시", 25, 8, "맑음"));
        weatherDTOList.add(new WeatherDTO("대전광역시", 25, 8, "맑음"));
        weatherDTOList.add(new WeatherDTO("울산광역시", 25, 8, "맑음"));
        weatherDTOList.add(new WeatherDTO("세종특별자치시", 23, 10, "구름 많음"));
        weatherDTOList.add(new WeatherDTO("경기도", 25, 8, "맑음"));
        weatherDTOList.add(new WeatherDTO("강원특별자치도", 25, 8, "맑음"));
        weatherDTOList.add(new WeatherDTO("충청북도", 21, 3, "맑음"));
        weatherDTOList.add(new WeatherDTO("충청남도", 20, 4, "맑음"));
        weatherDTOList.add(new WeatherDTO("전라북도", 19, 2, "맑음"));
        weatherDTOList.add(new WeatherDTO("전라남도", 19, 2, "맑음"));
        weatherDTOList.add(new WeatherDTO("경상북도", 25, 8, "맑음"));
        weatherDTOList.add(new WeatherDTO("경상남도", 25, 8, "맑음"));
        weatherDTOList.add(new WeatherDTO("제주특별자치도", 26, 17, "맑음"));
        System.out.println("100");
    }


    public List<WeatherDTO> selectInfo(String city) {
        List<WeatherDTO> selList = new ArrayList<>();
        for (WeatherDTO weatherDTO : weatherDTOList) {
            if (weatherDTO.getCity().equals(city) || city.equals("all")) {
                selList.add(weatherDTO);
            }
        }
        return selList;
    }

    public List<WeatherDTO> selectInfo(String[] checkes) {
        List<WeatherDTO> selList = new ArrayList<>();
        for (String check : checkes) {
            for (WeatherDTO weatherDTO : weatherDTOList) {
                if (check.equals(weatherDTO.getCity())) {
                    selList.add(weatherDTO);
                }
            }
        }
        return selList;
    }
}
