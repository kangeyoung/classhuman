package amusementPark;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {
    private String sId;
    private String sPass;
    private String sName;
    private boolean sGender;
    private int sAge;
    private String fPass;


    public void prt() {
        System.out.println("회원 ID: " + sId);
        System.out.println("회원 비밀번호: " + sPass);
        System.out.println("회원 이름: " + sName);
        if (sGender) {
            System.out.println("회원 성별: 남자");
        } else {
            System.out.println("회원 성별: 여자");
        }
        System.out.println("회원 나이: " + sAge);
        System.out.println("이용권 번호: " + fPass);
        System.out.println("-----------");
    }
}
