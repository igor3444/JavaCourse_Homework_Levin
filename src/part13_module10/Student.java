package part13_module10;

public class Student {

    String name;
    int age;
    String group;

    public Student(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    @Override
    public String toString() {
        return "Студент{" +
                "имя='" + name + '\'' +
                ", возраст=" + age +
                ", группа='" + group + '\'' +
                '}';
    }
}
