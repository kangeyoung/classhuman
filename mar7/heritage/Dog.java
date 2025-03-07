package mar7.heritage;

import java.util.Scanner;

public class Dog extends Super {
    String dogname;
    int dogage;
    Scanner sc = new Scanner(System.in);

    public Dog() {

    }

    @Override
    public void eatting() {
        System.out.println("개밥");
    }

    @Override
    public void menu() {
        System.out.println("보호자 이름 입력");
        username = sc.nextLine();
        System.out.println("강아지 이름 입력");
        dogname = sc.nextLine();
        System.out.println("1. 등록 2. 먹이주기 3. 잠자기");
    }

    @Override
    public void prt() {
        super.prt();
        System.out.println("강아지 이름:"+dogname);
    }
}
