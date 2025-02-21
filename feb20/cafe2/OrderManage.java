package feb20.cafe2;

import java.util.Scanner;

public class OrderManage {
    Scanner sc = new Scanner(System.in);
    Order[] orderList;
    Menu[] menuList;
    Review[] reviewList;

    //    Manage mn = new Manage();
    OrderManage(Manage manage) {
        this.orderList = manage.orderList;
        this.menuList = manage.menuList;
        this.reviewList = manage.reviewList;
    }

    public void startOrder() {
        System.out.println("----------------");
        while (true) {
            System.out.println("1. 주문 등록 2. 주문 확인 3. 리뷰 * Others. 종료");
            int num = sc.nextInt();
            sc.nextLine();
            switch (num) {
                case 1:
                    addOrder();
                    break;
                case 2:
                    printOrder();
                    break;
                case 3:
                    reviewCus();
                    break;
                default:
                    return;
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
            }
        }
    }

    private void printOrder() {
        System.out.println("------OrderList------");
        System.out.println("1. 전체 검색 2. 주문자 검색 * Others. 종료");
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

    private void prtOrderAll() {
        for (int i = 0; i < orderList.length; i++) {
            if (orderList[i] != null) {
                orderList[i].prtOrder();
            }
        }
    }

    private void prtOrderCus() {
        System.out.println("주문자 이름을 입력해주세요");
        String name = sc.nextLine();
        int cusNum = -1;
        for (int i = 0; i < orderList.length; i++) {
            if (orderList[i] != null && orderList[i].name.equals(name)) {
                cusNum = i;
                orderList[i].prtOrder();
                break;
            }
        }
        System.out.println("1. 후기 남기기 * Others. Exit");
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

    private void addOrder() {
        System.out.println("-----Add Order-----");
        System.out.println("주문자 이름을 적어주세요.");
        String name = sc.nextLine();
        Order order = new Order(name);
        for (int i = 0; i < orderList.length; i++) {
            if (orderList[i] == null) {
                orderList[i] = order;
                orderList[i].OrderMenu(menuList);
                break;
            } else if (orderList[i].name.equals(name)) {
                orderList[i].OrderMenu(menuList);
                break;
            } else if (i == 4) {
                System.out.println("주문은 5개까지만 등록 가능합니다.");
            }
        }


    }
}
