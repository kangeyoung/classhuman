package feb20.cafe2;

import java.util.Scanner;

public class MenuManage {
    Scanner sc = new Scanner(System.in);
    Menu[] menuList = new Menu[5];
    Review[] reviewList;

    MenuManage(Manage manage) {
        this.menuList = manage.menuList;
        this.reviewList = manage.reviewList;
    }
    public void startMenu(){
        System.out.println("----------------");
        while (true) {
            System.out.println("1. 메뉴 등록 2. 메뉴판 3. 리뷰 * Others. 종료");
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
                    return;
            }
        }
    }

    private void reviewMenu() {
        System.out.println("-----Review------");
        System.out.println("메뉴명을 입력해주세요.");
        String mName = sc.nextLine();
        for (int i = 0; i < 20; i++) {
            if (reviewList[i] != null && mName.equals(reviewList[i].mName)) {
                reviewList[i].prtReview();
                break;
            }
        }
    }
    private void printMenu() {
        System.out.println("-----Menu list-----");
        for (int i = 0; i < 5; i++) {
            if (menuList[i] != null) {
                menuList[i].prtMenu();
            }
        }
    }
    private void addMenu() {
        System.out.println("-----Add Menu-----");
        while (true) {
            System.out.println("메뉴 이름을 적어주세요.");
            String name;
            while (true) {
                name = sc.nextLine();
                int num = searchMenu(name);
                if (num != -1) {
                    System.out.println("메뉴 이름 중복. 다시 적어주세요.");
                    continue;
                }
                break;
            }
            System.out.println("메뉴 가격을 적어주세요.");
            String price = sc.nextLine();
            System.out.println("메뉴 설명을 적어주세요.");
            String description = sc.nextLine();
            Menu menu = new Menu(name, price, description);
            for (int i = 0; i < 5; i++) {
                if (menuList[i] == null) {
                    menuList[i] = menu;
                    break;
                }
            }
            int cnt = 0;
            for (int i = 0; i < 5; i++) {
                if (menuList[i] != null) {
                    cnt++;
                }
            }
            if (cnt == 5) {
                break;
            }
        }
    }
    public int searchMenu(String name) {
        for (int i = 0; i < 5; i++) {
            if (menuList[i] != null && name.equals(menuList[i].name)) {
                return i;
            }
        }
        return -1;
    }
}
