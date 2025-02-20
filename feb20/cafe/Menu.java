package feb20.cafe;

import java.util.Scanner;

public class Menu {
    String name;
    String price;
    String description;
    Review review;
    Menu(String name, String price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public void prtMenu() {
        System.out.print("메뉴 이름: "+name);
        System.out.print(" 메뉴 가격: "+price);
        System.out.println(" 메뉴 설명: "+description);
    }
}
