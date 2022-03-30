package part9_module7;


public class Employee extends Person implements Printable, Cloneable {

    int experience;


    public Employee(String name, String gender, int age, int experience) {
        super(name, gender, age);
        this.experience = experience;
    }


    public void employeeName() {
        System.out.println("- Сегодня вас будет обслуживать парикмахер: " + name);
    }
    public void employeeExperience () {
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

    @Override
    public String toString() {
        return "\nСотрудник: " + name;
    }

    @Override
    public int hashCode() {
        return 10 * name.hashCode() + 11322;
    }

    @Override
    public boolean equals (Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return this.name.equals(employee.name);
    }

    @Override
    public Employee clone() throws CloneNotSupportedException {
        return (Employee) super.clone();
    }
}
