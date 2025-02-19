package feb18.user;

public class User {

    String id;
    String name;
    int num = 0;
    int[] password = new int[num];

    User(String id, String name) {
        this.id = id; // this는 자신의 멤버변수
        this.name = name;
    }
    public void setNum(int num){
        this.num = num;
        password = new int[num];
    }
}
