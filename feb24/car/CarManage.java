package feb24.car;

import java.util.Scanner;

public class CarManage { // 자동차 관리, Car 객체를 등록하고 수정하고 삭제하는 책임
    private Car[] carList = new Car[10];

    CarManage() {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("1. 자동차 관리 2. 수리 정보");
            int num = sc.nextInt();
            sc.nextLine();
            switch (num) {
                case 1:
                    carInfo();
                    break;
                case 2:
                    repairCar();
                    break;
                default:
                    flag = false;
            }
        }
        sc.close();
    }

    private void repairCar() {
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
                carList[i].repairCar();
                break;
            case 2:
                carList[i].prtRepair();
                break;
            default:
                break;
        }
        sc.close();
    }

    private int searchCar(String carNum) {
        for (int i = 0; i < carList.length; i++) {
            if (carList[i] != null && carList[i].getCarNum().equals(carNum)) {
                return i;
            }
        }
        return -1;
    }

    private void carInfo() {
        System.out.println("1. 자동차 정보 입력 2. 전체 보기");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        switch (num) {
            case 1:
                addCar();
                break;
            case 2:
                viewCar();
                break;
            default:
                break;
        }
    }

    private void viewCar() {
        for (int i = 0; i < carList.length; i++) {
            if (carList[i] != null) {
                System.out.println("자동차 번호: " + carList[i].getCarNum() + " 소유자: " + carList[i].getCarUser());
            }
        }
    }

    private void addCar() {
        System.out.println("자동차 번호 입력");
        Scanner sc = new Scanner(System.in);
        String carNum = sc.nextLine();
        System.out.println("소유자 입력");
        String carUser = sc.nextLine();
        Car temp = new Car(carNum, carUser);
        for (int i = 0; i < carList.length; i++) {
            if (carList[i] == null) {
                carList[i] = temp;
                break;
            }
        }
    }
}
