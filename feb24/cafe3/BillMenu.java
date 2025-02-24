package feb24.cafe3;

public class BillMenu {
    String mName;
    int mPrice;
    int mQuantity;
    BillMenu(String mName, int mPrice, int mQuantity) {
        this.mName = mName;
        this.mPrice = mPrice;
        this.mQuantity = mQuantity;
    }
    public int prtBillMenu() {
        int price = mQuantity * mPrice;
        System.out.println(mName + " * " + mQuantity + " = " + price);
        return price;
    }
}
