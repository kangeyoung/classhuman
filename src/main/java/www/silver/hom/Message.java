package www.silver.hom;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class Message {
    private String nickname;
    private int timeString;
    private String msgText;
    public Message(String nickname, int timeString, String msgText) {
        this.nickname = nickname;
        this.timeString = timeString;
        this.msgText = msgText;
    }

}
