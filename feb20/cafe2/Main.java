package feb20.cafe2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("------Cafe Human-------");
        System.out.println("-----Enter = Start-----");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        Manage manage =new Manage();
        manage.startManage(manage);
    }
}
