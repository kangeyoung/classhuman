package mar4.parking;

import java.util.ArrayList;

import java.util.Scanner;

public class CarAdmin {
    private CarDAO carDAO = new CarDAO();

    CarAdmin() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. 차량등록 2. 차량조회 3. 수정 및 삭제 4. 종료");
            int num = sc.nextInt();
            sc.nextLine();
            switch (num) {
                case 1:
                    add();
                    break;
                case 2:
                    search();
                    break;
                case 3:
                    edit();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("번호 잘못 입력");
                    break;
            }
        }
    }

    private void edit() {
        System.out.println("----EDIT----");
        Scanner sc = new Scanner(System.in);
        System.out.println("차량번호 입력");
        String carnum = sc.nextLine();
        CarDTO car = carDAO.select(carnum);
        if (car.getCarnum() != null) {
            car.prt();
        }
        System.out.println("1. 정보 수정 2. 정보 삭제");
        int num = sc.nextInt();
        sc.nextLine();
        switch (num) {
            case 1:
                CarDTO newCar = makeInfo();
                carDAO.update(carnum, newCar);
                break;
            case 2:
                carDAO.delete(car);
                break;
            default:
                System.out.println("이전메뉴로 돌아갑니다.");
                break;
        }
    }

    private void search() {
        System.out.println("----SEARCH----");
        Scanner sc = new Scanner(System.in);
        System.out.println("1. 전체보기 2. 검색");
        int num = sc.nextInt();
        sc.nextLine();
        switch (num) {
            case 1:
                ArrayList<CarDTO> carList = carDAO.selectAll();
                for (CarDTO car : carList) {
                    car.prt();
                }
                break;
            case 2:
                System.out.println("차량번호 입력");
                String carnum = sc.nextLine();
                CarDTO car = carDAO.select(carnum);
                if (car.getCarnum() != null) {
                    car.prt();
                } else {
                    System.out.println("차량을 찾을 수 없습니다.");
                }
                break;
            default:
                System.out.println("이전메뉴로 돌아갑니다.");
                break;
        }
    }

    private CarDTO makeInfo() {
        Scanner sc = new Scanner(System.in);
        String carnum;
        while (true) {
            System.out.println("차 번호 입력");
            carnum = sc.nextLine();
            int result = carDAO.selectCarnum(carnum);
            if (result == 1) {
                System.out.println("중복입니다");
            } else {
                break;
            }
        }
        System.out.println("차 소유자 입력");
        String caruser = sc.nextLine();
        int parkingnum;
        while (true) {
            System.out.println("주차장 번호 입력");
            parkingnum = sc.nextInt();
            sc.nextLine();
            int result = carDAO.selectParking(parkingnum);
            if (result == 1) {
                System.out.println("중복입니다.");
            } else {
                break;
            }
        }
        CarDTO car = new CarDTO();
        car.setCarnum(carnum);
        car.setCaruser(caruser);
        car.setParking(parkingnum);
        return car;
    }

    private void add() {
        System.out.println("----ADD----");
        CarDTO car = makeInfo();
        carDAO.insert(car);
    }
}
