package feb25.carplus;

import java.util.Scanner;

public class StartMenu {
    private CarM carm = new CarM();
    private RepairM repairm = new RepairM();
    private TechnicianM technicianm = new TechnicianM();

    StartMenu() {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("메뉴를 선택해주세요.");
            System.out.println("1. 자동차 관리 2. 수리 관리 3. 자동차 수리리스트");
            int num = sc.nextInt();
            sc.nextLine();
            switch (num) {
                case 1:
                    carm.menu();
                    break;
                case 2:
                    // 차 번호 들고 오기
                    repairm.menu(carm.getCarListNum());
                    break;
                case 3:
                    // 차 번호 들고 오기
                    technicianm.menu(repairm.getRepairList());
                    break;
                default:
                    flag = false;
            }
        }
    }
}
