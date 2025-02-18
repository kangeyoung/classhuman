package feb18.user;

// 시작의 책임을 갖고 있는 클래스
public class Main {
    // main 메서드는 static 있어서 객체를 생성하지 않아도 호출 가능
    // 프로그램이 실행되면 JVM은 제일 먼저 main 메서드를 호출(call)
    public static void main(String[] args) {
        System.out.println("프로그램을 시작합니다.");
        // 객체 생성 생성자(인자); 생성자를 call하여 객체를 만든다.
        new UserManager("human");
    }
}
