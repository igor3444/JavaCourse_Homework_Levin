package part11_project2;

import java.util.Scanner;

public class Main {

    static Scanner console = new Scanner(System.in);
    static Broker broker = new Broker();

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в блокнот. Пожалуйста авторизуйтесь");
        broker.authorization();
        menu1();
    }

    public static void menu1() {
        boolean bool = true;
        while (bool) {
            try {
                System.out.println("1. Создать новую заметку");
                System.out.println("2. Найти заметку по названию");
                System.out.println("3. Вывести список заметок");                //-> Есть вход в другой метод
                System.out.println("4. Войти под другим пользователем");
                System.out.println("5. Завершить работу");
                int input = console.nextInt();
                console.nextLine();
                if (input == 1) {
                    if (broker.username.equals(Role.ADMIN) || broker.username.equals(Role.MODERATOR)) {
                        broker.creatingNote();                                        //-> Тупик
                    } else System.out.println("У вас недостаточно прав");
                } else if (input == 2) {
                    if (broker.Search()) {                                              //-> Должен быть вход в другой метод
                        menu2();
                    } else continue;
                } else if (input == 3) {
                    if (broker.showList()) {                                             //-> Есть вход в другой метод
                        menu2();                                                              //Заходим во второе меню
                    } else continue;
                } else if (input == 4) {
                    broker.authorization();
                } else if (input == 5) {
                    System.exit(0);
                } else {
                    System.out.println("Такого варианта нет. Выберите пункт из предложенного списка");
                }
            } catch (Exception a) {
                System.out.println("Что-то пошло не так. При вводе используйте только цифры");
                console.nextLine();
            }
        }                                                                                              //Незабыть добавить Exception
    }

    public static void menu2() {
        boolean bool = true;
        while (bool) {
            try {
                System.out.println("1. Изменить название заметки");
                System.out.println("2. Изменить тело заметки");
                System.out.println("3. Удалить заметку");
                System.out.println("4. Вернутся на главную страницу");
                int input = console.nextInt();
                console.nextLine();
                if (input == 1) {
                    if (broker.username.equals(Role.ADMIN) || broker.username.equals(Role.MODERATOR)) {
                        broker.changeName();
                    } else System.out.println("У вас недостаточно прав");
                } else if (input == 2) {
                    if (broker.username.equals(Role.ADMIN) || broker.username.equals(Role.MODERATOR)) {
                        broker.changeBody();
                    } else System.out.println("У вас недостаточно прав");
                } else if (input == 3) {
                    if (broker.username.equals(Role.ADMIN)) {
                        broker.deleteNote();
                        bool = false;
                    } else System.out.println("У вас недостаточно прав");
                } else if (input == 4) {
                    bool = false;
                } else {
                    System.out.println("Такого варианта нет. Выберите пункт из предложенного списка");
                }
            } catch (Exception a) {
                System.out.println("Что-то пошло не так. При вводе используйте только цифры");
                console.nextLine();
            }
        }
    }
}


