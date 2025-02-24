package feb24.car;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Repair {
    private Date date;
    private String content;
    public Repair(Date date, String content) {
        this.date = date;
        this.content = content;
    }
    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }

    public String getContent() {
        return content;
    }
}
