package part18_module14;

public class Car implements Runnable {

    Road road;

    public Car(Road road) {
        this.road = road;
    }

    @Override
    public void run() {
        try {
        while (!Thread.currentThread().isInterrupted()) {
            road.movementOfCars();
        }
        } catch (InterruptedException ie) {
            System.out.print("Thread Car has been interrupted");
        }
    }
}
