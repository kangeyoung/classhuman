package feb19.members;

import java.util.Scanner;

public class Member {
    String id; // 아이디
    String name; //
    String address;
    boolean minors = false;
    String[] hobbyList = new String[5];
    Memo[] memoList = new Memo[10];

    Member(String id, String name, String address, int minors) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.minors = minors != 1;
    }

    public void addMemo() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. 메모 추가 2. 메모 확인 그 외 숫자. 종료");
            int num = sc.nextInt();
            sc.nextLine();
            if (num == 1) {
                System.out.println("제목을 작성해주세요");
                String title = sc.nextLine();
                System.out.println("내용을 작성해주세요");
                String content = sc.nextLine();
                Memo memo = new Memo(title, content);
                for (int i = 0; i < memoList.length; i++) {
                    if (memoList[i] == null) {
                        memoList[i] = memo;
                        break;
                    }
                }
            } else if (num == 2) {
                for (int i = 0; i < memoList.length; i++) {
                    if (memoList[i] != null) {
                        memoList[i].prt();
                    }
                }
            } else {
                return;
            }
        }
    }

    public void addHobby() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("취미를 작성해주세요. 최대 5개까지 등록할 수 있습니다.");
            String hobby = sc.nextLine();
            if (hobby.isEmpty()) {
                break;
            }
            for (int i = 0; i < hobbyList.length; i++) {
                if (hobbyList[i] == null) {
                    hobbyList[i] = hobby;
                    break;
                } else if (i == hobbyList.length - 1) {
                    System.out.println("취미는 최대 5개 등록 가능합니다.");
                    return;
                }
            }
        }
    }

    public void prt() {
        System.out.print("아이디: " + id);
        System.out.print(" 이름: " + name);
        if (minors) {
            System.out.print("(미성년자)");
        }
        System.out.print(" 주소: " + address);
        if (hobbyList[1] != null) {
            System.out.print(" 취미: ");
            for (int j = 0; j < hobbyList.length; j++) {
                if (hobbyList[j] == null) {
                    break;
                }
                System.out.print(hobbyList[j] + " ");
            }
        }
        System.out.println();
    }
}
