package part7_module5;

public class Mercedes extends Car {
    private String mercedesHistory = "- Торговая марка и одноимённая компания - производитель легковых автомобилей премиального класса, грузовых автомобилей, автобусов и других транспортных средств, входящая в состав немецкого концерна «Daimler AG»...";
    private String feature;
    public int rating;

    public Mercedes(int maxSpeed, float horsepower, String colour, String feature) {
        super(maxSpeed, horsepower, colour);
        this.feature = feature;
    }
    public Mercedes() {}

    public String getFeature() {
        return "- Отличительная особенность Mercedes: " + feature;
    }

    public String getMercedesHistory() {
        return mercedesHistory;
    }
    public void setMercedesHistory(String mercedesHistory) {
        this.mercedesHistory = mercedesHistory;
    }

}
