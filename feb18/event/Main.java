package feb18.event;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("---EVENTS For everyone---");
        System.out.println("Enter를 누르면 관리 페이지로 넘어가실 수 있습니다.");
        s.nextLine();
        new EventManager();
    }
}
