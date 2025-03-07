package mar4.parking;

public class CarDTO {
    private String carnum;
    private String caruser;
    private int parking;

    public String getCarnum() {
        return carnum;
    }

    public void setCarnum(String carnum) {
        this.carnum = carnum;
    }

    public int getParking() {
        return parking;
    }

    public void setParking(int parking) {
        this.parking = parking;
    }

    public String getCaruser() {
        return caruser;
    }

    public void setCaruser(String caruser) {
        this.caruser = caruser;
    }

    public void prt(){
        System.out.println("차량 번호: "+carnum);
        System.out.println("차량 소유자: "+caruser);
        System.out.println("주차장 번호: "+parking);
    }
}
