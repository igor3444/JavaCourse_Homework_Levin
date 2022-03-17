package part8_module6;


public class Employee extends Person implements Printable, SeasonHandler {

    int experience;


    public Employee(String name, String gender, int age, int experience) {
        super(name, gender, age);
        this.experience = experience;
    }


    void employeeName() {
        System.out.println("- Сегодня вас будет обслуживать парикмахер: " + name);
    }
    void employeeExperience () {
        System.out.println("- Его опыт составляет " + experience + " лет");
    }

    @Override
    public void showName() {
        System.out.println("*" + name);
    }

    @Override
    public void showAge() {
        System.out.println("*" + age);
    }

    @Override
    public void showGender() {
        System.out.println("*" + gender);
    }
}
