package feb25.Main;

public class RepairOne {
    private String date;
    private String title;
    private String memo;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public void prt() {
        System.out.println("날짜: "+date);
        System.out.println("제목: "+title);
        System.out.println("내용: "+memo);
    }
}
