package feb24.cafe3;

public class Review {
    String mName;
    String cName;
    String content;
    Review(String mName, String cName, String content) {
        this.mName = mName;
        this.cName = cName;
        this.content = content;
    }
    public void prtReview(){
        System.out.println(mName + " - " + cName + "\n " + content);
    }
}
