package feb20.cafe;

import java.util.Scanner;

public class Order {
    String name;
    String[][] menuOrder = new String[5][3];

    Order(String nm) {
        this.name = nm;
    }

    public void printOrder() {
        System.out.println(name);
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            if (menuOrder[i][0] != null) {
                System.out.print("메뉴 이름: " + menuOrder[i][0]);
                System.out.print(" 메뉴 수량: " + menuOrder[i][1]);
                int a = Integer.parseInt(menuOrder[i][1]);
                int b = Integer.parseInt(menuOrder[i][2]);
                int price = a * b;
                sum += price;
                System.out.println(" 가격: " + price);
            }
        }
        System.out.println("총 계산 금액: " + sum);
    }

    public void OrderMenu(String[][] m) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("주문할 메뉴 번호를 입력해주세요. 동일한 메뉴를 주문할 경우 수량만 추가됩니다.");
            System.out.println("---메뉴판---");
            for (int i = 0; i < 5; i++) {
                System.out.println((i + 1) + ". " + m[i][0] + " " + m[i][1] + "원");
            }
            int menuNum = sc.nextInt();
            if (!(menuNum >= 1 && menuNum <= 5)) {
                System.out.println("주문 끝.");
                return;
            }
            String menuName = m[menuNum - 1][0];
            System.out.println("메뉴의 수량을 입력해주세요.");
            int menuQuantity = sc.nextInt();
            for (int i = 0; i < menuOrder.length; i++) {
                if (menuOrder[i][0] == null) {
                    menuOrder[i][0] = menuName;
                    menuOrder[i][1] = Integer.toString(menuQuantity);
                    menuOrder[i][2] = m[menuNum - 1][1];
                    break;
                } else if (menuName.equals(menuOrder[i][0])) {
                    int number = Integer.parseInt(menuOrder[i][1]);
                    number += menuQuantity;
                    menuOrder[i][1] = Integer.toString(number);
                    break;
                } else if (i == menuOrder.length - 1) {
                    System.out.println("주문 초과. 등록되지 않습니다.");
                    return;
                }
            }
        }
    }
}
