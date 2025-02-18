package feb18.user;

import java.util.Scanner;

public class UserManager {
    User[] userList = new User[5];
    Scanner in = new Scanner(System.in);

    // 생성자
    UserManager(String title) {
        System.out.println(title + " 회원관리프로그램");
        while (true) {
            menu();
            System.out.println("번호선택");
            int k = in.nextInt();
            in.nextLine();
            if (k == 1) {
                add();
            } else if (k == 2) {
                allList();
            } else {
                break;
            }
        }
    }

    private void allList() {
        System.out.println("전체보기 기능");
        for (int i = 0; i < userList.length; i++) {
            if (userList[i] != null) {
                System.out.print("아이디= " + userList[i].id);
                System.out.println(", 이름= " + userList[i].name);
            }
        }
    }

    private void add() {
        System.out.println("추가");
        System.out.println("아이디를 입력하세요");
        String id = in.nextLine();
        System.out.println("이름을 입력하세요");
        String name = in.nextLine();
        User tempUser = new User(id, name);
        for (int i = 0; i < userList.length; i++) {
            if (userList[i] == null) {
                userList[i] = tempUser;
                break;
            }
        }
    }

    private void menu() {
        System.out.println("1. 추가 2. 전체보기 \n그 외의 숫자를 누르면 종료됩니다.");
    }
}

