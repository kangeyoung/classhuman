package feb26.note;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class NoteM {
    private ArrayList<Note> notes = new ArrayList<>();
    private ArrayList<Note> shareNotes = new ArrayList<>();
    private UserM uM;
    private String id;

    public void startMenu(String id, UserM uM) {
        this.id = id;
        this.uM = uM;
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
        Scanner sc = new Scanner(System.in);
        System.out.println("1. 내 노트 보기 2. 공유노트 보기 Others. 이전 메뉴");
        int num = sc.nextInt();
        sc.nextLine();
        switch (num) {
            case 1:
                for (Note note : notes) {
                    note.prt();
                }
                System.out.println("1. 노트 공유 Others. 이전 메뉴");
                num = sc.nextInt();
                sc.nextLine();
                if (num == 1) {
                    shareNote();
                }
                break;
            case 2:
                for (Note note : shareNotes) {
                    note.prt();
                }
                break;
            default:
                break;
        }

    }

    private void shareNote() {
        System.out.println("공유할 노트 제목 입력");
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        int cho = searchTitle(title);
        if (cho != -1 && notes.get(cho).isOpen()) {
            System.out.println("-----------");
            for (String id : uM.getUserList().keySet()) {
                if (!id.equals(this.id)) {
                    System.out.println(id);
                }
            }
            System.out.println("-----------");
            System.out.println("공유할 아이디 입력");
            String id = sc.nextLine();
            uM.getUserList().get(id).getNoteM().shareNotes.add(notes.get(cho));
            System.out.println("공유 완료");
        } else {
            System.out.println("노트를 찾을 수 없거나 비공개한 노트입니다.");
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
