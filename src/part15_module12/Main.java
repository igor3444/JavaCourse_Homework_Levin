package part15_module12;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<User> users = setUsers();

        System.out.println("Сортировка людей по возрастанию зарплаты: ");
        users.stream().sorted(Comparator.comparing(User::getSalary)).forEach(System.out::println);
        System.out.println("\nСортировка людей по убыванию зарплаты");
        users.stream().sorted(Comparator.comparing(User::getSalary).reversed()).forEach(System.out::println);

        System.out.println("\nОтфильтрованная коллекция по возрасту > 25 лет");
        users.stream().filter(user -> user.getAge() > 25).forEach(System.out::println);

        System.out.println("\nОтсортированная и отфильтрованная коллекция по полю gender: ");
        Map<String, List<User>> groupUsersByGender = users.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.groupingBy(User::getGender));
        groupUsersByGender.forEach((gender1, users1) -> {
            System.out.println(gender1);
            users1.forEach(System.out::println);
                });

        System.out.println("\nВыбираем юзера с максимальной зарплатой: ");
        users.stream().max(Comparator.comparing(User::getSalary)).ifPresent(System.out::println);
        System.out.println("\nВыбираем юзера с минимальной зарплатой: ");
        users.stream().min(Comparator.comparing(User::getSalary)).ifPresent(System.out::println);

        System.out.println("\nПрактическон применение allMatch, anyMatch, noneMatch");
        System.out.println("Прожиточный минимум в России 45000 руб: " + users.stream().allMatch(User -> User.getSalary() > 45000));
        System.out.println("В России существуют люди с зарплатой больше 200 тысяч рублей в месяц: " + users.stream().anyMatch(User -> User.getSalary() > 200000));
        System.out.println("Люди младше 20 лет не могут получать зарплату: " + users.stream().noneMatch(Users -> Users.getAge() < 20));
    }

    private static List<User> setUsers () {
        return Arrays.asList(new User("Vlad", 23, "M", 24000), new User("Anton", 45, "M", 230000),
                new User("Ksyusha", 32, "F", 150000), new User("Sasha", 15, "M", 2000),
                new User("Liza", 27, "F", 75000));
    }
}
