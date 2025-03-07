package mar5.product;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    static final String hm = "hm";

    private String id;
    private String name;
    private String quantity;
    private String price;
    private String type;
    private String manager;
    private String date;
    private String description;
    boolean love = false;

    public void setLove(int love) {
        if (love == 1) {
            this.love = true;
        }
    }

    public void setProductDTO(String id, String name, String quantity, String price, String type, String manager, String description) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
        this.manager = manager;
        this.description = description;
    }

    public void prt() {
        if (love) {
            System.out.print("\uF06FID: " + id+"(★)");
        } else {
            System.out.print("\uF06FID: " + id);
        }
        System.out.println(" \uF06FName: " + name);
        System.out.print("\uF06FQuantity: " + quantity);
        System.out.println(" \uF06FPrice: " + price);
        System.out.print("\uF06FType: " + type);
        System.out.print(" \uF06FManager: " + manager);
        System.out.println(" \uF06FDate: " + date);
        System.out.println("\uF06FDescription: " + description);
        System.out.println("------------");
    }
}
