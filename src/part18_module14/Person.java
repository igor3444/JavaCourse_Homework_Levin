package part18_module14;

public class Person implements Runnable {

    Road road;

    public Person(Road road) {
        this.road = road;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                road.movementOfPersons();
            }
        } catch (InterruptedException ie) {
            System.out.print("Thread Person has been interrupted");
        }
    }
}
