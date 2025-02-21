package feb21;

import java.util.Scanner;

public class TestUser {
    String id;
    String name;
    String addr;
    boolean adultFlag = true;
    String[] hobby = new String[5];
    TestMemo[] memo = new TestMemo[10];

    public TestUser(String id, String name, String addr, boolean adultFlag) {
        this.id = id;
        this.name = name;
        this.addr = addr;
        this.adultFlag = adultFlag;
    }

    public void prt() { // 다른 클래스에서 멤버변수에 직접 접근하지 말고 prt()메서드를 통해서 접근해라(은닉화)
        System.out.println("아이디: " + id);
        String prtname = this.name;
        if (!adultFlag) {
            prtname += "(미성년자)";
        }
        System.out.println("이름: " + prtname);
        System.out.println("취미------");
        for (int i = 0; i < hobby.length; i++) {
            if (hobby[i] != null) {
                System.out.println(i + 1 + "." + hobby[i]);
            }
        }
        System.out.println("메모------");
        for (int i = 0; i < memo.length; i++) {
            if (memo[i] != null) {
                memo[i].prt();
            }
        }
    }

    public void menu() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("1.정보수정 2. 메모추가 3. 취미추가 4. 나의정보");
            int a = in.nextInt();
            in.nextLine();
            if (a == 1) {
                modInfo();
            } else if (a == 2) {
                addMemo();
            } else if (a == 3) {
                addHobby();
            } else if (a == 4) {
                prt();
            }

        }
    }

    private void addMemo() {
        Scanner in = new Scanner(System.in);
        System.out.println("제목입력");
        String title = in.nextLine();
        System.out.println("내용입력");
        String content = in.nextLine();
        TestMemo m = new TestMemo();
        m.setdata(title, content); // 클래스에 정보 저장할 때 직접입력보단 메서드를 통한 간접입력이 바람직함
        for (int i = 0; i < memo.length; i++) {
            if (memo[i] == null) {
                memo[i] = m;
                break;
            }
        }
    }

    private void addHobby() {
        Scanner in = new Scanner(System.in);
        System.out.println("최대 5개까지 입력이 가능합니다. 9:exit");
        for (int i = 0; i < 5; i++) {
            String hobbyName = in.nextLine();
            if (hobbyName.equals("9")) break;
            for (int j = 0; j < hobby.length; j++) {
                if (hobby[j] == null) {
                    hobby[j] = hobbyName;
                    break;
                }
            }
        }
    }

    private void modInfo() {
        Scanner in = new Scanner(System.in);
        System.out.println("새로운 이름을 입력");
        String name = in.nextLine();
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
