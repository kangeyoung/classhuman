package feb24.cafe3;

import java.util.Scanner;

public class MenuOne {
    String name;
    int price;
    String description;
    Review[] review = new Review[10];
    MenuOne(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
    public void prtMenu(){
        System.out.println(name + " : " + price + "\n " + description);
    }
    public void addReview(String cName){
        Scanner sc = new Scanner(System.in);
        System.out.println("리뷰 내용 입력");
        String content = sc.nextLine();
        for (int i = 0; i < review.length; i++) {
            if (review[i] == null) {
                review[i] = new Review(name, cName, content);
                break;
            }
        }
        sc.close();
    }
}
