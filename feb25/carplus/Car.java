package feb25.carplus;

public class Car {
    private String carNum;
    private String carUser;

    public String getCarNum() {
        return carNum;
    }

    public String getCarUser() {
        return carUser;
    }

    public Car(String carNum, String carUser) {
        this.carNum = carNum;
        this.carUser = carUser;
    }
}
