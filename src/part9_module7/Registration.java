package part9_module7;

public class Registration <E, K extends Printable> {

    private E employee;
    private K client;

    public Registration(E employee, K client) {
    this.employee = employee;
    this.client = client;
    }

    public void execute() {

        System.out.println("\nСотрудник:");
        ((Printable)employee).showName();
        ((Printable) employee).showAge();
        ((Printable) employee).showGender();

        System.out.println("\nКлиент:");
        ((Printable) client).showName();
        ((Printable) client).showAge();
        ((Printable) client).showGender();
    }
}
