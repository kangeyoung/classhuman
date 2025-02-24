package feb24.main;

import feb24.manager.UserManager;

public class Main {
    public static void main(String[] args) {
        new UserManager();
        // Main 클래스에서 UserManager 클래스를 의존한다.
        // 의존을 객체를 직접 만들어서 해결한다.
        // 객체를 만들 때 생성자로 객체를 만든다.
        // 생성자를 call한다. 즉, 접근한다.
    }

}
