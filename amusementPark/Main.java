package amusementPark;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter = Start");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();
        new MenuAdmin(id);
    }
}
