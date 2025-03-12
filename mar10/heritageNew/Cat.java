package mar10.heritageNew;

import mar10.inf.ServiceINF;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cat extends Super {
    String catname;
    int catage;
    Scanner sc = new Scanner(System.in);
    ServiceTool st = ServiceTool.getInstance();
    List<ServiceINF> servicelist = new ArrayList<>();

    public Cat() {
    }

    @Override
    public void menu() {
        System.out.println("보호자 이름 입력");
        username = sc.nextLine();
        System.out.println("고양이 이름 입력");
        catname = sc.nextLine();
        System.out.println("1. 등록 2. 먹이주기 3. 진료");
        System.out.println("11111");
        System.out.println("서비스 등록");
        addService();
    }

    private void addService() {
        ServiceINF service = st.choiceService();
        servicelist.add(service);
    }

    @Override
    public void prt() {
        super.prt();
        System.out.println("고양이 이름:" + catname);
        servicePrt();
    }

    private void servicePrt() {
        System.out.println("서비스 리스트 출력");
        for (ServiceINF service : servicelist) {
            service.info();
        }
    }
}
