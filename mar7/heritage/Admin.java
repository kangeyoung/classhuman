package mar7.heritage;


import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    ArrayList<Super> dd = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public Admin() {
        boolean f = true;
        while (f) {
            System.out.println("동물병원");
            System.out.println("1. 등록 2. 전체보기 3. 먹는방법");
            String a = sc.nextLine();
            switch (a) {
                case "1":
                    add();
                    break;
                case "2":
                    viewList();
                    break;
                case "3":
                    eat();
                    break;
                default:
                    f = false;


            }
//            Super s = new Super();
        }
    }

    private void viewList() {
        for (Super d : dd) {
            d.prt();
        }
    }

    private void add() {
        System.out.println("1. 개 2. 고양이");
        String a = sc.nextLine();
        Super s = null;
        switch (a) {
            case "1":
                s = new Dog();
                break;
            case "2":
                s = new Cat();
                break;
        }
        if (s != null) {
            s.menu();
        }
        dd.add(s);
    }

    private void eat() {
        for (Super s : dd) {
            s.eatting();
        }
    }
}
