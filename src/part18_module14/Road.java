package part18_module14;

public class Road {

    int person;
    int cars;

    public synchronized void movementOfPersons() throws InterruptedException {
        try {
            while (person <= 4) {
                wait(2000);
                person++;
                System.out.print("Людей: " + person + ", Машин: " + cars + "\r");
            }
            System.out.println("\nСветофор для пешеходов включен\n");
            person = 0;
        } catch (InterruptedException ie) {
            System.out.print("\n");
            throw new InterruptedException();
        }
    }

    public synchronized void movementOfCars() throws InterruptedException {
       try {
           while (cars <= 3) {
               wait(5000);
               cars++;
               System.out.print("Людей: " + person + ", Машин: " + cars + "\r");
           }
           System.out.println("\nСветофор для машин включен\n");
           cars = 0;
       } catch (InterruptedException ie) {
           System.out.print("\n");
           throw new InterruptedException();
       }
    }
}
