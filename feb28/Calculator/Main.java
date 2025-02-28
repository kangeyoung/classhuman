package feb28.Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("계산할 식을 입력하세요.");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        new Postfix(input);
    }
}
