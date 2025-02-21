package feb20.cafe2;

public class Review {
    String mName;
    String cName;
    String context;
    Review(String mName, String cName, String context) {
        this.mName = mName;
        this.cName = cName;
        this.context = context;
    }
    public void prtReview(){
        System.out.print("* 메뉴 이름: "+mName);
        System.out.println(" 주문자 이름: "+cName);
        System.out.println(context);
    }
}
