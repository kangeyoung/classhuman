package feb24.cafe3;

import java.util.Scanner;

public class StartMenu {

    StartMenu() {
        Scanner sc = new Scanner(System.in);
        MenuAdmin mAd = new MenuAdmin();
        OrderAdmin oAd = new OrderAdmin();
        while(true) {
            System.out.println("1. Menu 2. Order Others. Exit");
            int num = sc.nextInt();
            sc.nextLine();
            switch (num) {
                case 1:
                    mAd.start();
                    break;
                case 2:
                    oAd.start(mAd);
                    break;
                default:
                    return;
            }
        }
    }
}
