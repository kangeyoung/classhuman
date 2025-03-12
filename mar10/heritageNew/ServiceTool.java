package mar10.heritageNew;

import mar10.inf.BloodTest;
import mar10.inf.ServiceINF;
import mar10.inf.UnAnalysis;
import mar10.inf.Xray;

import java.util.Scanner;

public class ServiceTool {
    private static ServiceTool st = null;
    private ServiceTool() {

    }
    public static ServiceTool getInstance() { // 싱글톤
        if (st == null) {
            st= new ServiceTool();
        }
        return st;
    }
    public ServiceINF choiceService(){
        ServiceINF service = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("원하는 서비스를 선택하세요");
        System.out.println("1. 엑스 2. 소변 3. 혈액");
        int a = sc.nextInt();
        sc.nextLine();
        switch (a) {
            case 1:
                service = new Xray();
                break;
            case 2:
                service = new UnAnalysis();
                break;
            case 3:
                service = new BloodTest();
                break;
            default:
                break;
        }

        return service;
    }
}
