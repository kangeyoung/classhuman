package feb26.note;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserM {
    private HashMap<User, NoteM> noteList = new HashMap<>(20);

    private void menu(User user) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("1. 회원 수정 2. 노트 관리 3. 로그아웃");
            int num = sc.nextInt();
            sc.nextLine();
            switch (num) {
                case 1:
                    editUser(user);
                    break;
                case 2:
                    noteList.get(user).startMenu();
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("번호를 잘못 눌렀습니다.");
                    break;
            }
        }
    }

    private void editUser(User user) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("1. 비밀번호 변경 2. 회원 탈퇴 3. 이전 메뉴");
            int num = sc.nextInt();
            sc.nextLine();
            switch (num) {
                case 1:
                    System.out.println("새 비밀번호 입력");
                    String pass = sc.nextLine();
                    user.setPass(pass);
                    break;
                case 2:
                    noteList.remove(user);
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("번호를 잘못 눌렀습니다.");
                    break;
            }
        }
    }

    public void addUser() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("아이디 입력");
            String id = sc.nextLine();
            if (searchId(id) != null) {
                System.out.println("아이디 중복");
                continue;
            }
            System.out.println("비밀번호 입력");
            String pass = sc.nextLine();
            User user = new User(id, pass);
            NoteM note = new NoteM();
            noteList.put(user, note);
            return;
        }
    }

    public User searchId(String id) {
        for (Map.Entry<User, NoteM> entry : noteList.entrySet()) {
            if (entry.getKey().getId().equals(id)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("아이디 입력");
        String id = sc.nextLine();
        User user = searchId(id);
        if (user != null) {
            System.out.println("비밀번호 입력");
            String pass = sc.nextLine();
            if (user.getPass().equals(pass)) {
                System.out.println("로그인 성공");
                menu(user);
            } else {
                System.out.println("비밀번호가 틀렸습니다.");
            }
        } else {
            System.out.println("아이디가 없습니다.");
        }
    }


}
