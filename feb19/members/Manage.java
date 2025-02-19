package feb19.members;

import java.util.Arrays;
import java.util.Scanner;

public class Manage {
    Member[] memberList = new Member[5];
    Scanner sc = new Scanner(System.in);

    Manage() {
        System.out.println("------Manage------");
        while (true) {
            menu();
            int num = sc.nextInt();
            sc.nextLine();
            if (num == 1) {
                addMember();
            } else if (num == 2) {
                printMember();
            } else if (num == 3) {
                searchMember();
            } else if (num == 4) {
                modMember();
            } else if (num == 5) {
                addMemo();
            } else if (num == 6) {
                break;
            } else {
                System.out.println("번호 잘못 입력함");
            }
        }

    }

    private void addMemo() {
        System.out.println("------Add Memo------");
        System.out.println("아이디를 입력해주세요");
        String id = sc.nextLine();
        int i = searchId(id);
        if (i != -1) {
            memberList[i].addMemo();
        } else {
            System.out.println("아이디를 잘못 입력하셨습니다.");
        }
    }

    private void modMember() {
        System.out.println("------Modify MemberList------");
        System.out.println("수정시킬 아이디를 입력해주세요");
        String id = sc.nextLine();
        int i = searchId(id);
        if (i != -1) {
            System.out.println("1. 수정 2. 삭제 3. 취미 추가");
            int num = sc.nextInt();
            sc.nextLine();
            if (num == 1) {
                System.out.println("1. 전체 수정 2. 부분 수정 \n(아이디는 바꿀 수 없습니다.)");
                num = sc.nextInt();
                sc.nextLine();
                if (num == 1) {
                    modifyAll(i);
                } else if (num == 2) {
                    modifyPart(i);
                }
            } else if (num == 2) {
                memberList[i] = null;
            } else if (num == 3) {
                memberList[i].addHobby();
            }
        } else {
            System.out.println("아이디를 잘못 입력하셨습니다.");
        }
    }

    public void modifyAll(int i) {
        System.out.println("수정할 이름을 입력해주세요");
        memberList[i].name = sc.nextLine();
        System.out.println("수정할 주소를 입력해주세요");
        memberList[i].address = sc.nextLine();
        System.out.println("미성년자 여부를 체크하세요 \n1. 성년 2. 미성년");
        int minors = sc.nextInt();
        sc.nextLine();
        memberList[i].minors = minors != 1;
    }

    public void modifyPart(int i) {
        while(true) {
            System.out.println("정보 수정을 원하시는 부분을 입력해주세요 ex) name \n 종료를 입력하면 수정을 마칩니다");
            String con = sc.nextLine();
            if (con.equals("name")) {
                memberList[i].name = con;
            } else if (con.equals("address")) {
                memberList[i].address = con;
            } else if (con.equals("minors")) {
                System.out.println("1. 성년 2. 미성년자");
                int minors = sc.nextInt();
                sc.nextLine();
                memberList[i].minors = minors != 1;
            } else if (con.equals("종료")) {
                return;
            }
        }
    }

    private void searchMember() {
        System.out.println("------Search Member------");
        System.out.println("검색할 아이디를 입력해주세요(부분검색가능)");
        String searId = sc.nextLine();
        int sNum = searchIdNew(searId);
        if (sNum != -1) {
            memberList[sNum].prt();
            return;
        }
        System.out.println("찾을 수 없습니다.");
    }

    public int searchIdNew(String b) {

        for (int i = 0; i < memberList.length; i++) {
            int loc = 0;
            if (memberList[i] != null) {
                for (int j = 0; j < memberList[i].id.length(); j++) {
                    if (b.charAt(0) == memberList[i].id.charAt(j)) {
                        loc = j;
                        break;
                    }
                }
                for (int j = 0; j < b.length(); j++) {
                    if (b.charAt(j) != memberList[i].id.charAt(j + loc)) {
                        break;
                    } else if (j == b.length() - 1) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    private void printMember() {
        for (int i = 0; i < memberList.length; i++) {
            if (memberList[i] != null) {
                memberList[i].prt();
            }
        }
    }

    private void addMember() {
        System.out.println("------Add Member------");
        System.out.println("등록할 아이디를 입력해주세요");
        String id;
        while (true) {
            id = sc.nextLine();
            if (searchId(id) != -1) {
                System.out.println("아이디 중복. 다시 입력해주세요");
                continue;
            }
            break;
        }
        System.out.println("이름을 입력해주세요");
        String name = sc.nextLine();
        System.out.println("주소를 입력해주세요");
        String address = sc.nextLine();
        System.out.println("미성년자 여부를 체크하세요 \n1. 성년 2. 미성년");
        int minors = sc.nextInt();
        sc.nextLine();
        Member member = new Member(id, name, address, minors);
        for (int i = 0; i < memberList.length; i++) {
            if (memberList[i] == null) {
                memberList[i] = member;
                break;
            }
        }
    }

    public int searchId(String b) {
        for (int i = 0; i < memberList.length; i++) {
            if (memberList[i] != null && b.equals(memberList[i].id)) {
                return i;
            }
        }
        return -1;
    }

    private void menu() {
        System.out.println("1. Add Member 2. Print Memberlist 3. Search Member " +
                "4. Modify Memberlist 5. Add memo 6. Exit");
    }


}
