package feb21;

public class TestMemo {
    String title;
    String content;

    public void prt() {
        System.out.println("제목 : " + title);
        System.out.println("내용 : " + content);
    }

    public void setdata(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
