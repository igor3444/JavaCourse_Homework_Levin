package part9_module7;


public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        Employee employee = new Employee("Василий", "мужской", 34, 7);
        Client client = new Client("Ирина", "женский", 22, "жёлтый");

        Registration<Employee, Client> reg1 = new Registration<>(employee, client);


        System.out.println("Информация для клиента:");
        client.greetingClient();
        employee.employeeName();
        employee.employeeExperience();
        System.out.println("Информация для сотрудника: ");
        client.infoForTheEmployee();

        reg1.execute();

        System.out.println(employee.toString());
        System.out.println(client.toString());

        System.out.println("hashCode имени сотрудника = " + employee.hashCode());

        System.out.println("Класс объекта = " + reg1.getClass());

        System.out.println(employee.equals(client));                           //Здесь не проходит условие на этапе сравнения классов в Employee

        Employee employee2 = employee.clone();                                 //Клонирование объекта employee

        employee2.name = "Диана";                                              //Присваиваем переменной name объекта employee2 новое имя
        System.out.println(employee.name);                                     //
        System.out.println(employee2.name);                                    //
        System.out.println(employee.equals(employee2));                        //Сравниваем имена у двух объектов
    }
}
