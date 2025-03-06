package Mar5.product;

public class ProductDTO {
    static final String hm = "hm";
    String id;
    String name;
    String quantity;
    String price;
    String type;
    String manager;
    String date;
    String description;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getManager() {
        return manager;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void prt() {
        System.out.print("\uF06FID: " + id);
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
