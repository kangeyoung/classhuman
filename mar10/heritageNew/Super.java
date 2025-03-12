package mar10.heritageNew;

public abstract class Super {
    String username;
    String useraddr;

    public Super() {
    }

    public void eatting() {
        System.out.println("슈퍼eat");
    }

    public abstract void menu();
    public void prt(){
        System.out.println("보호자 이름:"+this.username);
    }
}
