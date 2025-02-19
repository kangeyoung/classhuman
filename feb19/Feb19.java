package feb19;

import feb18.event.Event;
import java.util.Random;
import java.util.Scanner;

public class Feb19 {
    public static void main(String[] args) {
        // static-> 객체를 안 만들어도 접근 가능하다. 모든 멤버변수와 메서드에 적어줘야 함
        new Event("a","b","c",true);// Event 의존(필요). new 객체 생성
        // JVM 안의 heap에서 객체의 생성, 소멸, 참조가 일어남
        // 객체 소멸(Garbage Collector)는 객체가 실행이 끝나고 객체를 참조하는 변수가 없을 때 일어난다.
        // Event 클래스에는 static이 없음 <- new로 객체를 만들어 사용할거라 static을 쓸 필요가 없다.
        // 생성자- 클래스를 객체로 생성할 때, 처음 call하는 메서드 리턴값 없음
        // nullpointException 참조하는 변수 value가 null이라면 그 변수에서 참조할 수 없다.
        // public을 써야 클래스 및 패키지 바깥에서도 접근할 수 있다.
        Scanner sc = new Scanner(System.in);
        System.out.println("스캐너 주소: " + sc);
        Random random = new Random();
        System.out.println("랜덤 주소: " + random);
        Event[] events = new Event[2];
        System.out.println("이벤트 주소: " + events);
    }
}
