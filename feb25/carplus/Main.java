package feb25.carplus;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter = Start");
        sc.nextLine();
        new StartMenu();
        sc.close();
    }
}
