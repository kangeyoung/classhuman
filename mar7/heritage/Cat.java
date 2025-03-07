package mar7.heritage;

import java.util.Scanner;

public class Cat extends Super {
    String catname;
    int catage;
    Scanner sc = new Scanner(System.in);

    public Cat() {
    }

    @Override
    public void menu() {
        System.out.println("보호자 이름 입력");
        username = sc.nextLine();
        System.out.println("고양이 이름 입력");
        catname = sc.nextLine();
        System.out.println("1. 등록 2. 먹이주기 3. 진료");
    }

    @Override
    public void prt() {
        super.prt();
        System.out.println("고양이 이름:" + catname);
    }
}
