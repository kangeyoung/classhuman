package feb18.event;

public class Event {
    String name;
    String description;
    String admin;
    boolean hide;
    Event(String name, String description, String admin,boolean hide) {
        this.name = name;
        this.description = description;
        this.admin = admin;
        this.hide = hide;


    }
}
