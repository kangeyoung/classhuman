package feb25.carplus;

public class Technician {
    private String techName;
    private String[] carNum = new String[5];

    public void setTechName(String techName) {
        this.techName = techName;
    }

    public void addCarNum(String carNum){
        for(int i = 0;i<this.carNum.length; i++){
            if(this.carNum[i] == null){
                this.carNum[i] = carNum;
                break;
            }
        }
    }

    public String getTechName() {
        return techName;
    }

    public String[] getCarNum() {
        return carNum;
    }
}
