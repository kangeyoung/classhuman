package feb21;

public class TestMain {
    public static void main(String[] args) {
        // 의존한다는 것은 객체가 필요핟.
        // 1. 객체를 만든다. 2. 객체의 주소값을 갖는다.
        TestUserAdmin testUserAdmin = null; // 객체를 알아야 한다.(의존)
        testUserAdmin =new TestUserAdmin(); // 객체를 직접 생성해서 알게 됨.
        testUserAdmin.mainStart();
    }
}
