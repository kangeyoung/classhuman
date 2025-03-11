package amusementPark;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationDTO {
    private int no;
    private String sId;
    private String fPass;
    private String rRide;
    private String rDate;

    public void prt() {
        System.out.println("예약번호: " + no);
        System.out.println("회원아이디: " + sId);
        System.out.println("이용권번호: " + fPass);
        System.out.println("놀이기구이름: " + rRide);
        System.out.println("예약시간: " + rDate);
        System.out.println("-----------");
    }
}
