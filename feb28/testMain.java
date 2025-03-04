package feb28;

import java.util.Scanner;

public class testMain {
    public static void main(String[] args) {
        System.out.println("계산할 식을 입력하세요.");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        new testPostfix1(input);
    }
}
