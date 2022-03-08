package part7_module5;

public class BMW extends Car {
    private String bmwHistory = "- Промышленная фирма была основана Карлом Фридрихом Раппом в октябре 1916 года...";
    private String feature;
    public int rating;

    public BMW(int maxSpeed, float horsepower, String colour, String feature) {
        super(maxSpeed, horsepower, colour);
        this.feature = feature;
    }
    public BMW() {}

    public String getFeature() {
        System.out.println(super.getFeature());
        return "- Отличительная особенность BMW: " + feature;
    }

    public String getBmwHistory() {
        return bmwHistory;
    }
    public void setBMWHistory(String bmwHistory) {
        this.bmwHistory = bmwHistory;
    }
}
