package feb26.note;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Note {
    private Date date;
    private String title;
    private String content;
    private boolean open;
    private ArrayList<CheckList> checklists = new ArrayList<>();

    Note(Date date, String title, String content, boolean open) {
        this.date = date;
        this.title = title;
        this.content = content;
        this.open = open;
    }

    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("(yyyy-MM-dd)");
        return formatter.format(date);
    }

    public String getTitle() {
        return title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String StringOpen() {
        if (open) {
            return "-공개-";
        } else {
            return "-비공개-";
        }
    }

    public boolean isOpen() {
        return open;
    }

    public void addChecklist() {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("내용 입력");
            String content = sc.nextLine();
            CheckList checklist = new CheckList(content);
            checklists.add(checklist);
            System.out.println("1. 다음 체크리스트 입력 2. 이전 메뉴");
            int cho = sc.nextInt();
            sc.nextLine();
            if (cho == 2) {
                flag = false;
            }
        }
    }

    public void prt() {
        if (checklists == null) {
            System.out.println(title + getDate() + StringOpen() + "\n -" + content);
        } else {
            System.out.println(title + getDate() + StringOpen() + "\n -" + content);
            for (CheckList checklist : checklists) {
                System.out.println(checklist.doneEmo() + " " + checklist.getContent());
            }
        }
    }

    public void prtCheck() {
        for (CheckList checklist : checklists) {
            if (!checklist.isDone()) {
                System.out.println(checklist.doneEmo() + " " + checklist.getContent());
            }
        }
    }

    public void editCheck() {
        Scanner sc = new Scanner(System.in);
        prtCheck();
        System.out.println("수정할 내용 입력");
        String content = sc.nextLine();
        int i = searchContent(content);
        if (i != -1) {
            System.out.println("1. 내용 수정 2. 완료 표시");
            int num = sc.nextInt();
            sc.nextLine();
            switch (num) {
                case 1:
                    System.out.println("새 내용 입력");
                    content = sc.nextLine();
                    checklists.get(i).setContent(content);
                    break;
                case 2:
                    checklists.get(i).setDone(true);
                    break;
            }
        }
    }

    private int searchContent(String content) {
        for (int i = 0; i < checklists.size(); i++) {
            if (content.equals(checklists.get(i).getContent())) {
                return i;
            }
        }
        return -1;
    }
}
