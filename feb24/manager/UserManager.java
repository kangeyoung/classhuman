package feb24.manager;

import java.util.Scanner;

public class UserManager {
    private User[] ulist = new User[5];
    public UserManager() {
        boolean flag = true;
        while(flag) {
            System.out.println("1. 등록 2. 전체보기");
            Scanner in = new Scanner(System.in);
            int a = in.nextInt();
            in.nextLine();
            switch (a) {
                case 1:
                    add();
                    break;
                case 2:
                    viewlist();
                    break;
                default:
                    System.out.println("조기퇴근");
                    flag = false;
            }
        }


    }

    private void viewlist() {

    }

    private void add() {
        User user = new User();
        user.setId("kkk"); // 비지니스 관점에서 kkk 이름을 저장해주세요.
        user.setName("난도둑놈");
        System.out.println(user.getId());
    }
}
