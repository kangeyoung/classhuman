package feb25.carplus;

import java.util.Arrays;
import java.util.Scanner;

public class TechnicianM {
    private Technician[] technicianList = new Technician[5];
    private Repair[] repairList;

    public void menu(Repair[] repairList) {
        this.repairList = repairList;
        Scanner sc = new Scanner(System.in);
        System.out.println("1. 수리리스트 추가");
        int num = sc.nextInt();
        sc.nextLine();
        if(num == 1){
            addTechList();
        }
    }

    private void printRepairList() {
        for (Repair repair : repairList) {
            if (repair != null) {
                System.out.println("자동차 번호: " + repair.getCarNum() + "(" + repair.getTitle() + ")");
            }
        }
    }

    private void addTechList() {
        Scanner sc = new Scanner(System.in);
        System.out.println("정비사 이름 입력");
        String techName = sc.nextLine();
        int num = searchList(techName);
        if (num != -1) {
            System.out.println("수리할 자동차 번호: "+ Arrays.toString(technicianList[num].getCarNum()));
            System.out.println("수리할 자동차를 추가하시겠습니까?");
            int cho = sc.nextInt();
            sc.nextLine();
            if (cho == 1) {
                System.out.println("새로운 정비사님 환영합니다. \n수리할 자동차를 추가하시겠습니까? \n1. 추가 2. 안한다");
                int choice = sc.nextInt();
                sc.nextLine();
                if (choice == 1) {
                    printRepairList();
                    System.out.println("수리할 자동차 번호를 입력해주세요.");
                    String carNum = sc.nextLine();
                    technicianList[num].addCarNum(carNum);
                }
            }
        } else {
            System.out.println("새로운 정비사님 환영합니다. \n수리할 자동차를 추가하시겠습니까? \n1. 추가 2. 안한다");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                printRepairList();
                System.out.println("수리할 자동차 번호를 입력해주세요.");
                String carNum = sc.nextLine();
                for (int i = 0; i < technicianList.length; i++) {
                    if (technicianList[i] == null) {
                        technicianList[i] = new Technician();
                        technicianList[i].setTechName(techName);
                        technicianList[i].addCarNum(carNum);
                    }
                }
            }
        }
    }

    private int searchList(String techName) {
        for (int i = 0; i < technicianList.length; i++) {
            if (technicianList[i] != null && technicianList[i].getTechName().equals(techName)) {
                return i;
            }
        }
        return -1;
    }
}
