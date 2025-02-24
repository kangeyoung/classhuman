package feb24.cafe3;

import java.util.Scanner;

public class OrderAdmin {
    BillOrder[] orderList = new BillOrder[5];
    MenuAdmin mAd;

    public void start(MenuAdmin mAd) {
        this.mAd = mAd;
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("1. 주문 추가 2. 주문 확인 3. 리뷰 보기 Others. Exit");
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
        Scanner sc = new Scanner(System.in);
        System.out.println("주문자명 입력");
        String name = sc.nextLine();
        for (int i = 0; i < orderList.length; i++) {
            if (orderList[i] != null && orderList[i].name.equals(name)) {
                for (int j = 0; j < mAd.menuList.length; j++) {
                    for(int z = 0; z<10;z++) {
                        if (mAd.menuList[j].review[z].cName.equals(name)) {
                            mAd.menuList[j].review[z].prtReview();
                        }
                    }
                }
            }
        }
    }

    private void printOrder() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. 전체 검색 2. 주문자명 검색");
        int num = sc.nextInt();
        sc.nextLine();
        switch (num) {
            case 1:
                for (int i = 0; i < orderList.length; i++) {
                    orderList[i].prtOrder();
                }
                break;
                case 2:
                    System.out.println("주문자명 검색");
                    String name = sc.nextLine();
                    num = search(name);
                    if (num != -1) {
                        orderList[search(name)].prtOrder();
                        System.out.println("1. 후기 남기기 Others. Exit");
                        int cho = sc.nextInt();
                        if(cho == 1){
                           orderList[search(name)].addReview();
                        }
                    }else{
                        System.out.println("주문자를 찾을 수 없습니다.");
                    }
        }
        sc.close();
    }

    private int search(String name) {
        for (int i = 0; i < orderList.length; i++) {
            if (orderList[i] != null && orderList[i].name.equals(name)) {
                return i;
            }
        }
        return -1;
    }

    private void addOrder() {
        Scanner sc = new Scanner(System.in);
        System.out.println("주문자명 입력");
        String name = sc.nextLine();
        BillOrder temp = new BillOrder(name, mAd);
        for(int i = 0; i<orderList.length; i++) {
            if(orderList[i]==null){
                orderList[i]=temp;
            }
        }

    }

}
