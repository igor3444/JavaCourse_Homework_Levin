package part8_module6;


public class Main {

    public static void main(String[] args) {

        Employee employee = new Employee("Василий", "мужской", 34, 7);
        Client client = new Client("Ирина", "женский", 22, "жёлтый");

        System.out.println("Информация для клиента:");
        client.greetingClient();
        employee.employeeName();
        employee.employeeExperience();
        System.out.println("Информация для сотрудника: ");
        client.infoForTheEmployee();

        System.out.println("\nСотрудник:");
        ((Printable) employee).showName();
        ((Printable) employee).showAge();
        ((Printable) employee).showGender();

        System.out.println("\nКлиент:");
        ((Printable) client).showName();
        ((Printable) client).showAge();
        ((Printable) client).showGender();

        System.out.println();

        SeasonHandler sh = client;
        sh.getSeason(Season.AUTUMN);
    }
}
