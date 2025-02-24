package feb24.cafe3;

import java.util.Scanner;

public class BillOrder {
    String name;
    BillMenu[] menu = new BillMenu[5];
    MenuAdmin mAd;

    BillOrder(String name, MenuAdmin mAd) {
        this.name = name;
        this.mAd = mAd;
        orderMenu();
    }

    public void prtOrder() {
        System.out.println(name);
        int sum = 0;
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] != null) {
                sum += menu[i].prtBillMenu();
            }
        }
        System.out.println("합계 금액: " + sum);
    }

    public void orderMenu() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            mAd.printMenu();
            System.out.println("주문할 메뉴 번호 입력 Others. Exit");
            int num = sc.nextInt() - 1;
            sc.nextLine();
            if (num < 0 || num > 4) {
                return;
            }
            String mName = mAd.menuList[num].name;
            int mPrice = mAd.menuList[num].price;
            System.out.println("주문할 수량 입력");
            int mQuantity = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < menu.length; i++) {
                if (menu[i] != null && menu[i].mName.equals(mName)) {
                    menu[i].mQuantity += mQuantity;
                } else {
                    menu[i] = new BillMenu(mName, mPrice, mQuantity);
                }
            }
            sc.close();
        }
    }

    public void addReview() {
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] != null) {
                for (int j = 0; j < mAd.menuList.length; j++) {
                    if (menu[i].mName.equals(mAd.menuList[j].name)) {
                        Scanner sc = new Scanner(System.in);
                        System.out.println("2. Exit");
                        int cho = sc.nextInt();
                        sc.close();
                        if (cho == 2) {
                            return;
                        }
                        mAd.menuList[j].addReview(name);
                    }
                }
            }
        }
    }
}
