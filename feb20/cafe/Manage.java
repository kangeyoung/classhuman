package feb20.cafe;

import java.util.Scanner;

public class Manage {
    Scanner sc = new Scanner(System.in);
    Menu[] menuList = new Menu[5];
    Order[] orderList = new Order[5];
    Review[] reviewList = new Review[20];

    Manage() {
        System.out.println("-----Cafe Manage-----");
        while (true) {
            System.out.println("--1. Menu Manage 2. Order Manage Others. Exit--");
            int num = sc.nextInt();
            sc.nextLine();
            if (num == 1) {
                startC(1);
                num = sc.nextInt();
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
                        break;
                }
            } else if (num == 2) {
                startC(2);
                num = sc.nextInt();
                sc.nextLine();
                switch (num) {
                    case 1:
                        printMenu();
                        addOrder();
                        break;
                    case 2:
                        printOrder();
                        break;
                    case 3:
                        reviewCus();
                        break;
                    default:
                        break;
                }
            } else {
                break;
            }
        }
    }

    private void reviewCus() {
        System.out.println("-----Review Menu-----");
        System.out.println("주문자명을 입력해주세요.");
        String cName = sc.nextLine();
        for (int i = 0; i < 20; i++) {
            if (reviewList[i] != null && cName.equals(reviewList[i].cName)) {
                reviewList[i].prtReview();
                break;
            }
        }
    }

    private void reviewMenu() {
        System.out.println("-----Review Menu-----");
        System.out.println("메뉴명을 입력해주세요.");
        String mName = sc.nextLine();
        for (int i = 0; i < 20; i++) {
            if (reviewList[i] != null && mName.equals(reviewList[i].mName)) {
                reviewList[i].prtReview();
                break;
            }
        }
    }

    private void printOrder() {
        System.out.println("------OrderList------");
        System.out.println("1. 전체 검색 2. 주문자 검색");
        int num = sc.nextInt();
        sc.nextLine();
        switch (num) {
            case 1:
                prtOrderAll();
                break;
            case 2:
                prtOrderCus();
                break;
        }
    }

    private void prtOrderCus() {
        System.out.println("주문자 이름을 입력해주세요");
        String name = sc.nextLine();
        int cusNum = -1;
        for (int i = 0; i < orderList.length; i++) {
            if (orderList[i] != null && orderList[i].name.equals(name)) {
                cusNum = i;
                orderList[i].printOrder();
                break;
            }
        }
        System.out.println("1. 후기 남기기 Others. Exit");
        int num = sc.nextInt();
        sc.nextLine();
        if (num == 1) {
            reviewOrder(cusNum);
        }
    }

    private void reviewOrder(int i) {
        for (int j = 0; j < 5; j++) {
            String menuName = orderList[i].menuOrder[j][0];
            if (menuName != null) {
                System.out.println(menuName + "의 후기를 남겨주세요.");
                String context = sc.nextLine();
                Review review = new Review(menuName, orderList[i].name, context);
                for (int s = 0; s < reviewList.length; s++) {
                    if (reviewList[s] == null) {
                        reviewList[s] = review;
                    }
                }
                System.out.println("1. 다른 메뉴도 후기 남기기 Others. Exit");
                int num = sc.nextInt();
                sc.nextLine();
                if (num != 1) {
                    return;
                }
            }
        }
    }

    public void prtOrderAll() {
        for (int i = 0; i < orderList.length; i++) {
            if (orderList[i] != null) {
                orderList[i].printOrder();
            }
        }
    }

    private void printMenu() {
        System.out.println("------Cafe Menu------");
        for (int i = 0; i < 5; i++) {
            if (menuList[i] != null) {
                menuList[i].prtMenu();
            }
        }
    }

    public String[][] getMenu() {
        String[][] menu1 = new String[5][2];
        for (int i = 0; i < 5; i++) {
            menu1[i][0] = menuList[i].name;
            menu1[i][1] = menuList[i].price;
        }
        return menu1;
    }

    private void addOrder() {
        System.out.println("-----Add Order-----");
        String nm;
        System.out.println("주문자 이름을 적어주세요.");
        nm = sc.nextLine();
        Order order = new Order(nm);
        for (int i = 0; i < 5; i++) {
            if (orderList[i] == null) {
                orderList[i] = order;
                String[][] menu1 = getMenu();
                orderList[i].OrderMenu(menu1);
                break;
            } else if (orderList[i].name.equals(nm)) {
                String[][] menu1 = getMenu();
                orderList[i].OrderMenu(menu1);
                break;
            } else if (i == 4) {
                System.out.println("주문은 5개까지만 등록 가능합니다.");
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

    private void startC(int num) {
        System.out.println("--1. Menu Manage 2. Order Manage--");
        if (num == 1) {
            System.out.println("1. Add Menu 2. Print Menu  3. Print Review Others. Exit");
        } else if (num == 2) {
            System.out.println("1. Add Order 2. Print Order 3. Print Review Others. Exit");
        }
    }

}
