package feb20.cafe2;

public class Menu {
    String name;
    String price;
    String description;
    Review[] reviewList = new Review[20];
    Menu(String name, String price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
    public void prtMenu(){
        System.out.println("메뉴 이름: "+name + " 메뉴 가격: " + price + " 메뉴 설명: " + description);
    }

    public void addreview(){

    }
}
