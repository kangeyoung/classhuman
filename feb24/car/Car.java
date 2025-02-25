package feb24.car;

import java.util.Date;
import java.util.Scanner;

public class Car { // 자동차 한대 책임
    private String carNum;
    private String carUser;
    private Repair[] repair = new Repair[10];
    Car(String carNum, String carUser) {
        this.carNum = carNum;
        this.carUser = carUser;
    }
    public String getCarNum() {
        return carNum;
    }

    public String getCarUser() {
        return carUser;
    }

    public void prtRepair() {
        for (int i = 0; i < repair.length; i++) {
            if (repair[i] == null) {
                break;
            }else {
                System.out.println("날짜: "+repair[i].getDate());
                System.out.println(" -"+repair[i].getContent());
            }
        }
    }

    public void repairCar() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            Date date = new Date();
            System.out.println("수리 내용 입력");
            String content = sc.nextLine();
            Repair temp = new Repair(date, content);
            for (int i = 0; i < repair.length; i++) {
                if (repair[i] == null) {
                    repair[i] = temp;
                    break;
                }
            }
            System.out.println("Exit = 1");
            int num = sc.nextInt();
            sc.nextLine();
            if(num == 1){
                break;
            }
        }
    }

}
