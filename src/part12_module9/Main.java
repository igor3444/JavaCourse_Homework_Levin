package part12_module9;

import java.util.*;

public class Main {

    static Scanner console = new Scanner(System.in);

    static Comparator<Student> scomp = new StudentNameComparator().thenComparing(new StudentAgeComparator());
    static TreeSet<Student> setOfStudents = new TreeSet<Student>(scomp);

    public static void main(String[] args) {

        boolean bool = true;
        while (bool) {
            try {
                System.out.println("1. Ввести ученика");
                System.out.println("2. Вывести всех учеников по возрастанию");
                System.out.println("3. Вывести всех учеников по убыванию");
                System.out.println("4. Удалить ученика по номеру");
                System.out.println("5. Выйти из программы\n");

                int choice = console.nextInt();
                console.nextLine();
                if (choice == 1) {
                    addStudent();
                } else if (choice == 2) {
                    int count = 1;
                    for (Student setOfStudent : setOfStudents) {
                        System.out.println("№" + count + "\n" + setOfStudent.toString());
                        count++;
                    }
                } else if (choice == 3) {
                    NavigableSet<Student> descSetOfStudents = setOfStudents.descendingSet();
                    int count = 1;
                    for (Student descSetOfStudent : descSetOfStudents) {
                        System.out.println("№" + count + "\n" + descSetOfStudent.toString());
                        count++;
                    }
                } else if (choice == 4) {
                    deleteStudent();
                } else if (choice == 5) {
                    System.exit(0);
                } else System.out.println("Упс. Выбранный вами вариант не существует, попробуйте ещё раз!");
            } catch (Exception a) {
                System.out.println("Упс. Пожалуйста будьте внимательны при вводе данных");
                console.nextLine();
            }
        }
    }

    public static void addStudent() {
        System.out.print("Введите ФИО: ");
        String name = console.nextLine();
        System.out.print("Введите возраст: ");
        Double age = console.nextDouble();
        console.nextLine();
        System.out.print("Введите класс: ");
        String class_ = console.nextLine();
        System.out.println("Выберите любимый предмет: ");

        List<Subject> enumSubject = Arrays.asList(Subject.values());                          //Создаём простой список и помещаем туда наши предметы из Enum
        for (Subject sub : enumSubject) {                                                     //Затем выводим их пользователю
            System.out.println((enumSubject.indexOf(sub)) + 1 + ". " + sub);
        }

        System.out.print("Введите номер предмета: ");
        int choiceSub = console.nextInt();
        console.nextLine();
        Subject subject = enumSubject.get(choiceSub - 1);                                       //Записываем в переменную subject, выбранный пользователем предмет
        System.out.println("Вы выбрали: " + subject);


        if (setOfStudents.add(new Student(name, age, class_, subject))) {
            System.out.println("Ученик успешно занесён в базу");
        } else System.out.println("Ученик уже есть в базе");
    }

    public static void deleteStudent() {
            ArrayList<Student> listStudent = new ArrayList<Student>(setOfStudents);                           //Перезаписываем наш набор состудентами в список, чтобы к студенту можно было обратится по индексу
            for (Student student : listStudent) {                                                             //Т.к. набор не имеет индексов.
                System.out.println("№" + (listStudent.indexOf(student) + 1) + "\n" + student.toString());
            }

            System.out.print("Введите номер студента для удаления: ");
            int choice = console.nextInt();
            console.nextLine();
            if (choice > 0 && choice <= listStudent.size()) {
                listStudent.remove(choice - 1);                                                                         //Удаляем студента по индексу в списке
                setOfStudents.clear();                                                                                        //Полностью очищаем наш набор со студентами
                setOfStudents.addAll(listStudent);                                                                            //Присваиваем набору новую коллекцию listStudent
                System.out.println("Студент успешно удалён");
            } else System.out.println("Такого студента не существует");
    }
}

