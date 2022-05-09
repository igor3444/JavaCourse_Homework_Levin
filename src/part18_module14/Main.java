package part18_module14;

public class Main {

    public static void main(String[] args) {

        Road road = new Road();
        Person person = new Person(road);
        Car car = new Car(road);
        Thread p = new Thread(person);
        Thread c = new Thread(car);
        p.start();
        c.start();
        try {
            Thread.sleep(30000);
            p.interrupt();
            c.interrupt();
        } catch (InterruptedException ignored) {
        }
    }
}
