package part8_module6;

public enum Season {

    SUMMER ("red"),
    AUTUMN ("yellow"),
    WINNER ("white"),
    SPRING ("brown");

    private String color;

    Season(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
