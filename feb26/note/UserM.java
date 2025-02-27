package feb26.note;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserM {
    // 회원 리스트
    private HashMap<String, User> userList = new HashMap<>(20);

    public HashMap<String, User> getUserList() {
        return userList;
    }

    public void addUser(){
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("아이디 입력");
            String id = sc.nextLine();
            if (userList.containsKey(id)) {
                System.out.println("아이디 중복");
                continue;
            }
            System.out.println("비밀번호 입력");
            String password = sc.nextLine();
            NoteM noteM = new NoteM();
            User user = new User();
            user.setPass(password);
            user.setNoteM(noteM);
            userList.put(id,user);
            return;
        }
    }

    public void login(UserM uM){
        Scanner sc = new Scanner(System.in);
        System.out.println("아이디 입력");
        String id = sc.nextLine();
        if(userList.containsKey(id)) {
            System.out.println("비밀번호 입력");
            String pass = sc.nextLine();
            if(userList.get(id).getPass().equals(pass)) {
                System.out.println("로그인 성공");
                menu(id, uM);
            }
        }else{
            System.out.println("아이디가 없습니다.");
        }
    }

    private void menu(String id, UserM uM) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("1. 회원 수정 2. 노트 관리 3. 로그아웃");
            int num = sc.nextInt();
            sc.nextLine();
            switch (num) {
                case 1:
                    editUser(id);
                    break;
                case 2:
                    userList.get(id).getNoteM().startMenu(id,uM);
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

    private void editUser(String id) {
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
                    userList.get(id).setPass(pass);
                    break;
                case 2:
                    userList.remove(id);
                    flag = false;
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
}
