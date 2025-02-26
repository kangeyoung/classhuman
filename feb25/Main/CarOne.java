package feb25.Main;


import java.util.ArrayList;
import java.util.Scanner;

public class CarOne {
    private String num;
    private String userName;

    //    private RepairOne[] repairList = new RepairOne[5];
    private ArrayList<RepairOne> repairList = new ArrayList<RepairOne>();

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("1. 수리등록 2. 전체보기");
            System.out.println("번호선택");
            int a = sc.nextInt();
            sc.nextLine();
            switch (a) {
                case 1:
                    addRepair();
                    break;
                case 2:
                    listRepair();
                    break;
                default:
                    flag = false;
            }
        }
    }

    private void listRepair() {

        for (RepairOne repairOne : repairList) {
//            if(repairList[i] != null){
//                repairList[i].prt();
//            }
            repairOne.prt();
        }

    }

    private void addRepair() {
        Scanner sc = new Scanner(System.in);
        System.out.println("날짜와 제목과 내용을 차례대로 입력");
        String date = sc.nextLine();
        String title = sc.nextLine();
        String memo = sc.nextLine();
        RepairOne repairOne = new RepairOne();
        repairOne.setDate(date);
        repairOne.setTitle(title);
        repairOne.setMemo(memo);
        repairList.add(repairOne);
//        for(int i = 0; i < repairList.length; i++){
//            if (repairList[i] == null){
//                repairList[i] = repairOne;
//                break;
//            }
//        }
    }

    public void prt() {
        System.out.println("차량번호: " + this.num);
        System.out.println("소유자: " + this.userName);
    }
}
