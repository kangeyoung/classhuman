package www.silver.hom;

import java.time.LocalTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatService {
    private Map<String, Integer> userList = new HashMap<>();
    private List<Message> msgList = new ArrayList<>();

    public boolean addUser(String nickname, int sTime) {
        if (userList.containsKey(nickname)) {
            System.out.println(false);
            return false;
        } else {
            userList.put(nickname, sTime);
            System.out.println(true);
            return true;
        }
    }

    public void addMsg(String nickName, int timeString, String msgText) {
        msgList.add(new Message(nickName, timeString, msgText));
    }

    public ArrayList<String> printMsg(String nickName) {
        ArrayList<String> msgStringList = new ArrayList<>();
        for (int i = msgList.size() - 1; i >= 0 && msgStringList.size() < 10; i--) {
            int a = msgList.get(i).getTimeString();
            System.out.println("sendTime");
            System.out.println(a);
            int b = userList.get(nickName);
            System.out.println("starttime");
            System.out.println(b);
            if (a > b) {
                StringBuilder msg = new StringBuilder();
                msg.append("[").append(a).append("] ").append(msgList.get(i).getNickname()).append(": ").append(msgList.get(i).getMsgText());
                msgStringList.add(msg.toString());
            }
        }
        return msgStringList;
    }
}
