package feb24.cafe3;

import java.util.Scanner;

public class MenuAdmin {
    MenuOne[] menuList = new MenuOne[5];

    public void start() {
        while (true) {
            System.out.println("1. 메뉴판 작성 2. 메뉴판 확인 3. 리뷰 보기 Others. Exit");
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            sc.nextLine();
            switch (num) {
                case 1:
                    addMenu();
                    break;
                case 2:
                    printMenu();
                    break;
                case 3:
                    reviewMenu();
                    break;
                default:
                    sc.close();
                    return;
            }
        }
    }

    private void reviewMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("메뉴 이름 입력");
        String name = sc.nextLine();
        for (int i = 0; i < menuList.length; i++) {
            if (menuList[i].name.equals(name)) {
                for(int j = 0; j<menuList[i].review.length; j++){
                    menuList[i].review[j].prtReview();
                }
            }
        }
        sc.close();
    }

    public void printMenu() {
        for (int i = 0; i < menuList.length; i++) {
            if (menuList[i] != null) {
                System.out.print(i+1+" ");
                menuList[i].prtMenu();
            }
        }
    }

    private void addMenu() {
        while (menuList[5] != null) {
            Scanner sc = new Scanner(System.in);
            System.out.println("이름 입력");
            String name = sc.nextLine();
            System.out.println("가격 입력");
            int price = sc.nextInt();
            System.out.println("설명 입력");
            String description = sc.nextLine();
            MenuOne tempMenuOne = new MenuOne(name, price, description);
            for (int i = 0; i < menuList.length; i++) {
                if (menuList[i] == null) {
                    menuList[i] = tempMenuOne;
                }
            }
        }
    }
}
