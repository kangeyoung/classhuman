package cafe;

import java.util.Scanner;

public class Manage {
    Menu[] menuList;
    Order[] orderList;
    Review[] reviewList = new Review[20];

    Manage() {
        System.out.println("----------------");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. 메뉴 관리 2. 주문 관리");
            int num = sc.nextInt();
            if (num == 1) {
                MenuManage meMn = new MenuManage();
                meMn.startMenu();
                menuList = meMn.menuList;
            } else if (num == 2) {
                OrderManage odMn = new OrderManage();
                odMn.startOrder();
                orderList = odMn.orderList;
                break;
            } else {
                return;
            }
        }
    }
}
