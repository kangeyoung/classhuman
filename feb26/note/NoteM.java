package feb26.note;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class NoteM {
    private ArrayList<Note> notes = new ArrayList<>();

    public void startMenu() {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("1. 노트 추가 2. 노트 수정 3. 노트 보기 4. 이전 메뉴");
            int num = sc.nextInt();
            sc.nextLine();
            switch (num) {
                case 1:
                    addNote();
                    break;
                case 2:
                    editNote();
                    break;
                case 3:
                    viewNote();
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("번호를 잘못 눌렀습니다.");
                    break;
            }
        }
    }

    private void viewNote() {
        for (Note note : notes) {
            note.prt();
        }
    }

    private void editNote() {
        Scanner sc = new Scanner(System.in);
        System.out.println("노트 제목 입력");
        String title = sc.nextLine();
        int i = searchTitle(title);
        if (i != -1) {
            System.out.println("1. 내용 수정 2. 체크리스트 수정");
            int num = sc.nextInt();
            sc.nextLine();
            switch (num) {
                case 1:
                    editContent(i);
                    break;
                case 2:
                    editCheck(i);
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("노트를 찾을 수 없습니다.");
        }
    }

    private void editCheck(int i) {
        Scanner sc = new Scanner(System.in);
        notes.get(i).editCheck();
    }

    private void editContent(int i) {
        Scanner sc = new Scanner(System.in);
        System.out.println("새 내용 입력");
        String content = sc.nextLine();
        notes.get(i).setContent(content);
    }

    private int searchTitle(String title) {
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getTitle().equals(title)) {
                return i;
            }
        }
        return -1;
    }

    private void addNote() {
        Scanner sc = new Scanner(System.in);
        Date date = new Date();
        System.out.println("제목 입력");
        String title = sc.nextLine();
        System.out.println("내용 입력");
        String content = sc.nextLine();
        boolean open = false;
        System.out.println("1. 공개 2. 비공개");
        int cho = sc.nextInt();
        sc.nextLine();
        if (cho == 1) {
            open = true;
        }
        Note note = new Note(date, title, content, open);
        System.out.println("1. 체크리스트 추가 Others. 이대로 저장");
        int num = sc.nextInt();
        sc.nextLine();
        if (num == 1) {
            note.addChecklist();
            notes.add(note);
        } else {
            notes.add(note);
        }
    }
}
