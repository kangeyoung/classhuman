package feb25.Main;



import java.util.Scanner;

public class CarM {
    private CarOne[] carList = new CarOne[5];

    public CarOne[] getCarList() {
        return carList;
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println(this.hashCode() + "객체주소");
            System.out.println("1. 자동차등록 2. 전체보기");
            System.out.println("번호를 선택하세요.");
            int a = sc.nextInt();
            sc.nextLine();
            switch (a) {
                case 1:
                    insertCar();
                    break;
                case 2:
                    listCar();
                    break;
                default:
                    flag = false;
            }
        }
    }

    private void listCar() {
    for(CarOne c : carList){
        if(c != null){
            c.prt();
        }
    }
    }

    private void insertCar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("번호와 소유자를 차례대로 입력하세요.");
        String num = sc.nextLine();
        String userName = sc.nextLine();
        CarOne carone = new CarOne();
        carone.setNum(num);
        carone.setUserName(userName);
        for(CarOne c : carList){
            if(c == null){
                c = carone;
                break;
            }
        }
    }


}
