package feb20.cafe;

import feb19.members.Manage;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("------Main------");
        Scanner s = new Scanner(System.in);
        System.out.println("Enter = Start Manage");
        s.nextLine();
        new Manage();
    }

}

