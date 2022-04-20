package part13_module10;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;

public class Main {

    static int count1 = 0;

    public static void main(String[] args) {

        ArrayList<Person> listOfPeople = new ArrayList<Person>();
        ArrayList<Student> listOfStudent = new ArrayList<Student>();
        Student tempStudent;

        Scanner console = new Scanner(System.in);

        System.out.println("Добро пожаловать. Введите данные человека для анализа его личности");
        boolean bool = true;
        while (bool) {
            System.out.print("Введите ФИО: ");
            String name = console.nextLine();
            System.out.print("Введите возраст: ");
            int age = console.nextInt();
            console.nextLine();
            System.out.print("Введите год рождения: ");
            int year = console.nextInt();
            listOfPeople.add(new Person(name, age, year));
            count1++;

            Function<Person, Student> convert = (person) -> {
                try {
                    if (person.age > 17 && person.age <= 40) {
                        if (person.year < 1995) {
                            return new Student(person.name, person.age, "у6ИН-01-22");
                        } else return new Student(person.name, person.age, "у6ИН-02-22");
                    } else throw new Exception("Данный человек не является студентом");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    return null;
                }
            };
            tempStudent = convert.apply(listOfPeople.get(count1 - 1));
            if (tempStudent != null)
                listOfStudent.add(tempStudent);
            System.out.println("Список студенов:");
            for (Student student : listOfStudent) {
                System.out.println(student);
            }
            System.out.println("1. Продолжить вводить людей");
            System.out.println("2. Выйти из программы");
            int choice = console.nextInt();
            console.nextLine();
            if (choice == 1) {
                continue;
            } else if (choice == 2)
                System.exit(0);
        }
    }
}
