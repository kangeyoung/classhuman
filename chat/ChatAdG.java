package chat;

import javaproject.DAO.AdminDAO;
import javaproject.DTO.AdminDTO;

import javax.swing.*;

public class ChatAdG extends JFrame {
    public ChatAdG(String id) {
        AdminDAO adminDAO = new AdminDAO();
        AdminDTO adminDTO = adminDAO.select(id);
        String aPosition = adminDTO.getAPosition();
        switch (aPosition) {
            case "놀이공원":
                new ClientV3(id, 3);
                break;
            case "음식점":
                new ClientV3(id, 4);
                break;
            case "티켓":
                new ClientV3(id, 5);
                break;
            default:
                JOptionPane.showMessageDialog(null, "접근 권한 없음");
                break;
        }
    }

}
