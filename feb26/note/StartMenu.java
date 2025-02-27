package feb26.note;

import java.util.Scanner;

public class StartMenu {
    StartMenu() {
        Scanner sc = new Scanner(System.in);
        UserM uM = new UserM();
        while (true) {
            System.out.println("1. 회원등록 2. 로그인 Others. Exit");
            int num = sc.nextInt();
            sc.nextLine();
            switch (num) {
                case 1:
                    uM.addUser();
                    break;
                case 2:
                    uM.login(uM);
                    break;
                default:
                    return;
            }
        }
    }
}
