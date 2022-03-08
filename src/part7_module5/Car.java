package part7_module5;

public abstract class Car {

    private int maxSpeed;
    private float horsepower;
    private String colour;

    public Car(int maxSpeed, float horsepower, String colour) {
        this.maxSpeed = maxSpeed;
        this.horsepower = horsepower;
        this.colour = colour;
    }

    public Car() {}

    public void specifications() {
        System.out.println("Скорость: " + maxSpeed);
        System.out.println("л.с: " + horsepower);
        System.out.println("Цвет: " + colour);
    }

    public String getFeature() {
        return "* Современные автомобили отличаются от своих прошлых поколений в первую очередь безопасностью и жесткостью кузова.";
    }
}
