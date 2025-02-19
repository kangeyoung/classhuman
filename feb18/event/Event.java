package feb18.event;

public class Event {
    String name; // 이벤트 이름
    String description; // 이벤트 설명
    String admin; // 관리자
    boolean hide; // 숨길지 말지
    public Event(String name, String description, String admin, boolean hide) {
        this.name = name;
        this.description = description;
        this.admin = admin;
        this.hide = hide;
    }
}
