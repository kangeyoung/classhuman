package feb25.carplus;

import java.util.Date;
import java.util.Scanner;

public class RepairM {
    private Repair[] repairList = new Repair[20];
    private String[] carListNum = new String[10];

    public Repair[] getRepairList() {
        return repairList;
    }

    public void menu(String[] carListNum) {
        this.carListNum = carListNum;
        Scanner sc = new Scanner(System.in);
        System.out.println("자동차 번호를 입력하세요");
        String carNum = sc.nextLine();
        int i = searchCar(carNum);
        if (i != -1) {
            System.out.println("1. 수리정보 입력 2. 전체 보기");
        } else {
            System.out.println("자동차를 찾을 수 없습니다.");
            return;
        }
        int num = sc.nextInt();
        sc.nextLine();
        switch (num) {
            case 1:
                repairCar(carNum);
                break;
            case 2:
                prtRepair(carNum);
                break;
            default:
                break;
        }
    }

    private void prtRepair(String carNum) {
        for (Repair repair : repairList) {
            if (repair != null && repair.getCarNum().equals(carNum)) {
                System.out.println(repair.getTitle() + repair.getDate() + "\n -" + repair.getContent());
            }
        }
    }

    private void repairCar(String carNum) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            Date date = new Date();
            System.out.println("제목 입력");
            String title = sc.nextLine();
            System.out.println("내용 입력");
            String content = sc.nextLine();
            Repair temp = new Repair(carNum, date, title, content);
            for (int i = 0; i < repairList.length; i++) {
                if (repairList[i] == null) {
                    repairList[i] = temp;
                    break;
                }
            }
            System.out.println("Exit = 1");
            int num = sc.nextInt();
            sc.nextLine();
            if (num == 1) {
                break;
            }
        }
    }

    private int searchCar(String carNum) {
        for (int i = 0; i < carListNum.length; i++) {
            if (carListNum[i] != null && carListNum[i].equals(carNum)) {
                return i;
            }
        }
        return -1;
    }
}
