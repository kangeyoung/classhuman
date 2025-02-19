package feb19.members;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("------Members------");
        Scanner s = new Scanner(System.in);
        System.out.println("Enter = Start Manage");
        s.nextLine();
        new Manage();
    }
}
