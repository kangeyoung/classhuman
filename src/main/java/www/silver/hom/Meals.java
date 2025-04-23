package www.silver.hom;

public class Meals {
    String rice;
    String soup;
    String mainMeal;

    public Meals(String rice, String soup, String mainMeal) {
        this.rice = rice;
        this.soup = soup;
        this.mainMeal = mainMeal;
    }

    public String getRice() {
        return rice;
    }

    public String getSoup() {
        return soup;
    }

    public String getMainMeal() {
        return mainMeal;
    }
}
