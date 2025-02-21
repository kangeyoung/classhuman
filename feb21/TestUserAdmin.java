package feb21;

import javax.xml.namespace.QName;
import java.util.Scanner;

public class TestUserAdmin {
    Scanner in = new Scanner(System.in);
    TestUser[] ulist;

    public void mainStart() {
        while (true) {
            menu();
            System.out.println("선택");
            int a = in.nextInt();
            in.nextLine();
            if (a == 1) {
                add();
            } else if (a == 2) {
                list();
            } else if (a == 3) {
                delete();
            } else if (a == 4) {
                mod();
            } else if (a == 5) {
                search();
            } else {
                break;
            }
            in.close();
        }

    }

    public void menu() {
        System.out.println("1. add 2. list 3. delete 4. mod 5. search");
    }

    public void add() {
        Scanner in = new Scanner(System.in);
        System.out.println("사용자 추가");
        System.out.println("아이디 입력");
        String id = in.nextLine();
        System.out.println("이름 입력");
        String name = in.nextLine();
        System.out.println("주소 입력");
        String addr = in.nextLine();
        System.out.println("1. 성인 2. 미성년자");
        String a= in.nextLine();
        boolean adultFlag = true;
        if (a.equals("2")) adultFlag = false;
        TestUser testUser = new TestUser(id, name, addr,adultFlag);
        for (int i = 0; i < ulist.length; i++) {
            if (ulist[i] == null) {
                ulist[i] = testUser; // 주소를 저장함
                break;
            }
        }
        in.close();
    }

    public void list() {
        for (int i = 0; i < ulist.length; i++) {
            if (ulist[i] != null) { // 안 쓰면 nullpointexception 발생
                ulist[i].prt();
            }
        }
    }

    public void delete() {
        Scanner in = new Scanner(System.in);
        System.out.println("삭제할 아이디 입력");
        String id = in.nextLine();
        for (int i = 0; i < ulist.length; i++) {
            if (ulist[i] != null) { // null은 참조불가능
                if (ulist[i].id.equals(id)) {
                    ulist[i] = null;
                    break;
                }
            }
        }
        in.close(); // 자원을 빌려왔으면 반납하자.
    }

    public void mod() {
        // 아이디를 입력받아서 수정
        // 순서 1. 아이디를 입력받는다. 2. 배열에 찾는다. 3. 수정한다.(이름만)
        Scanner in = new Scanner(System.in);
        System.out.println("아이디 입력");
        String id = in.nextLine(); // 1.
        for (int i = 0; i < ulist.length; i++) {
            if (ulist[i] != null) {
                if (ulist[i].id.equals(id)) { // 2.
//                    System.out.println("수정할 이름을 입력"); // 3.
//                    String name = in.nextLine();
//                    ulist[i].name = name; User 클래스의 멤버변수에 직접 접근하는 것은 객체지향언어에서 바람직하지 않다.
//                    ulist[i].setName(name);
                    ulist[i].menu();
                }
            }
        }
    }

    public void search() {
        Scanner in = new Scanner(System.in);
        System.out.println("검색어(id)를 입력하세요.");
        String id = in.nextLine();
        for (int i = 0; i < ulist.length; i++) {
            if (ulist[i] != null) {
//                if (ulist[i].id.equals(id)) { indexOf 메서드 이용
                if (ulist[i].id.indexOf(id) != -1) {
                    ulist[i].prt();
                }
            }
        }
    }

}

