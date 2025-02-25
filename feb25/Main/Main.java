package feb25.Main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarM carm = new CarM();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("1. 자동차관리 2. 수리관리");
            int a = sc.nextInt();
            sc.nextLine();
            switch (a) {
                case 1:
                    carm.menu();
                    break;
                case 2:
                    System.out.println("수리할 자동차 번호를 입력");
                    String carnum = sc.nextLine();
                    CarOne[] list = carm.getCarList();
                    for(CarOne c:list){ // list를 0번 인덱스부터 순회를 하면서 value를 변수 c에 저장한다.
                        if(c !=null){
                            if(c.getNum().equals(carnum)){
                                System.out.println("다음 정보의 차를 찾았습니다.");
                                c.prt();
                                c.menu();
                            }
                        }
                    }
                    break;
                default:
                    flag = false;
            }
        }
    }
}
