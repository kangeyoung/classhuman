package feb25.carplus;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Repair {
    private String carNum;
    private Date date;
    private String title;
    private String content;

    public String getCarNum() {
        return carNum;
    }

    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("(yyyy-MM-dd)");
        return formatter.format(date);
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Repair(String carNum, Date date, String title, String content) {
        this.carNum = carNum;
        this.date = date;
        this.title = title;
        this.content = content;
    }


}
