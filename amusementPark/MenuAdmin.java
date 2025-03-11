package amusementPark;


import java.util.ArrayList;
import java.util.Scanner;

public class MenuAdmin {
    String id;
    AdminDAO adminDAO = new AdminDAO();

    public MenuAdmin(String id) {
        this.id = id;
        while (true) {
            System.out.println("1. 회원 조회 2. 관리자 조회 3. 예약 조회");
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            sc.nextLine();
            switch (num) {
                case 1:
                    menuMemberM();
                    break;
                case 2:
                    menuAdminM(id);
                    break;
                case 3:
                    menuReservation();
                    break;
                default:
                    return;
            }
        }
    }

    private void menuAdminM(String id) {
        System.out.println("---관리자조회---");
        System.out.println("1. 수정 2. 삭제");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        switch (num) {
            case 1:
                adminDAO.updateAdm(id);
                break;
            case 2:
                adminDAO.deleteAdm(id);
                break;
            default:
                break;
        }

    }

    public void menuMemberM() {
        System.out.println("---회원조회---");
        ArrayList<MemberDTO> memberlist = adminDAO.selectMem();
        if(memberlist != null) {
            for (MemberDTO m : memberlist) {
                m.prt();
            }
            System.out.println("1. 수정 2. 삭제");
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            sc.nextLine();
            System.out.println("수정할 회원 아이디 입력");
            String sId = sc.nextLine();
            switch (num) {
                case 1:
                    adminDAO.updateMem(sId);
                    break;
                case 2:
                    adminDAO.deleteMem(sId);
                    break;
                default:
                    break;
            }
        }
    }

    public void menuReservation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---예약조회---");
        ArrayList<ReservationDTO> reservationList = adminDAO.selectRes();
        for (ReservationDTO r : reservationList) {
            r.prt();
        }
        System.out.println("1. 삭제");
        int num = sc.nextInt();
        System.out.println("예약번호 입력");
        int no = sc.nextInt();
        sc.nextLine();
        if (num == 1) {
            adminDAO.deleteRes(no);
        }
    }


}
