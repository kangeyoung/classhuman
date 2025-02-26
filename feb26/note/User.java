package feb26.note;

public class User {
    private String id;
    private String pass;

    User(String id, String pass) {
        this.id = id;
        this.pass = pass;
    }

    public String getId() {
        return id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
