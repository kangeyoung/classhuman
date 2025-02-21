package feb20.cafe2;

import java.util.Scanner;

public class Manage {
    Menu[] menuList= new Menu[5];
    Order[] orderList= new Order[5];
    Review[] reviewList = new Review[20];

    public void startManage(Manage manage) {
        System.out.println("----------------");
        Scanner sc = new Scanner(System.in);
        MenuManage meMn = new MenuManage(manage);
        OrderManage odMn = new OrderManage(manage);
        while (true) {
            System.out.println("1. 메뉴 관리 2. 주문 관리");
            int num = sc.nextInt();
            if (num == 1) {
                meMn.startMenu();
            } else if (num == 2) {
                odMn.startOrder();
            } else {
                break;
            }
        }
    }
}
