package mar10.heritageNew;


import mar10.inf.BloodTest;
import mar10.inf.ServiceINF;
import mar10.inf.UnAnalysis;
import mar10.inf.Xray;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dog extends Super {
    String dogname;
    int dogage;
    Scanner sc = new Scanner(System.in);
    ServiceTool st = ServiceTool.getInstance();
    List<ServiceINF> servicelist = new ArrayList<>();


    public Dog() {

    }

    @Override
    public void eatting() {
        System.out.println("개밥");
    }

    @Override
    public void menu() {
        System.out.println("보호자 이름 입력");
        super.username = sc.nextLine();
        System.out.println("강아지 이름 입력");
        dogname = sc.nextLine();
        System.out.println("1. 등록 2. 먹이주기 3. 잠자기");
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
        System.out.println("강아지 이름:" + dogname);
        servicePrt();
    }

    private void servicePrt(){
        System.out.println("서비스 리스트 출력");
        for (ServiceINF service : servicelist) {
            service.info();
        }
    }
}
