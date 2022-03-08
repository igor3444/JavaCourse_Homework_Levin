package part7_module5;

public class Audi extends Car {
    private String audiHistory = "- Штаб-квартира расположена в городе Ингольштадт (Германия). Девиз — Vorsprung durch Technik...";
    private String feature;
    public int rating;

    public Audi(int maxSpeed, float horsepower, String colour, String feature) {
        super(maxSpeed, horsepower, colour);
        this.feature = feature;
    }

    public Audi() {}

    public String getFeature(){
        return "- Отличительная особенность Audi: " + feature;
    }

    public String getAudiHistory() {
        return audiHistory;
    }
    public void setAudiHistory(String audiHistory) {
        this.audiHistory = audiHistory;
    }
}
