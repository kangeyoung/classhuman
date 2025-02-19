package feb19.members;

public class Memo {
    String title;
    String content;

    public Memo(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void prt() {
        System.out.println("제목: " + title);
        System.out.println("    내용: " + content);
    }
}
