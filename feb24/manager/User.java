package feb24.manager;

public class User {
    private String id = null;
    private String name = null;

    public void setId(String id) { // Setter
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() { // Getter
        return this.id;
    }
}
