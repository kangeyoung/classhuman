package feb26.note;

public class CheckList {
    private boolean done;
    private String content;

    CheckList(String content) {
        this.done = false;
        this.content = content;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isDone() {
        return done;
    }

    public String DoneEmo() {
        if (done) {
            return "\uF0FE";
        } else {
            return "\uF06F";
        }
    }

    public String getContent() {
        return content;
    }
}
