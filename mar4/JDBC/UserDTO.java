package mar4.JDBC;

public class UserDTO {
    private String name;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void prt() {
        System.out.println("id: " + this.id + "\nname: " + this.name);
    }
}
