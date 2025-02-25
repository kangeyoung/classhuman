package feb25.carplus;

import java.util.Scanner;

public class CarM {
    private Car[] carList = new Car[10];

    public String[] getCarListNum() {
        String[] carListNum = new String[10];
        for (int i = 0; i < carList.length; i++) {
            if (carList[i] != null) {
                carListNum[i] = carList[i].getCarNum();
            }
        }
        return carListNum;
    }

    public void menu() {
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
        for (Car car : carList) {
            if (car != null) {
                System.out.println("자동차 번호: " + car.getCarNum() + " 소유자: " + car.getCarUser());
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
