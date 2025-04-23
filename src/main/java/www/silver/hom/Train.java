package www.silver.hom;

public class Train {
    String region;
    String name;
    String dTime;
    String aTime;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getdTime() {
        return dTime;
    }

    public void setdTime(String dTime) {
        this.dTime = dTime;
    }

    public String getaTime() {
        return aTime;
    }

    public void setaTime(String aTime) {
        this.aTime = aTime;
    }

    public Train(String region, String name, String dTime, String aTime) {
        this.region = region;
        this.name = name;
        this.dTime = dTime;
        this.aTime = aTime;
    }
}
