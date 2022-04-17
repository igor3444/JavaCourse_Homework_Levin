package part12_module9;

public class Student {             // implements Comparable<Student>    //Данный интерфейс мы могли бы использовать, если бы мы сортировали по какому то одному полю
                                                                        //Т.к. нам нужна сортировка по двум полям, то мы создаём два собственных класса компаратора и добавляем их к нашей коллекции
    String name;                                                        //В классе Main.
    Double age;
    String class_;
    Subject subject;

    public Student(String name, Double age, String class_, Subject subject) {
        this.name = name;
        this.age = age;
        this.class_ = class_;
        this.subject = subject;
    }
    String getName() {
        return name;
    }
    double getAge() {
        return age;
    }

    public String toString() {
        return "Имя: " + name + "\nВозраст: " + age + " лет" + "\nКласс: " + class_ + "\nЛюбимый предмет: " + subject;
    }

//    public int compareTo(Student s) {
//        return name.compareTo(s.getName());
//    }
}
