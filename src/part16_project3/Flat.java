package part16_project3;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Flat {

    static Scanner console = new Scanner(System.in);
    public static List<Flat> listOfApartments = new ArrayList<>();
    String roomName;
    String metroStation;
    String address;
    int numberOfRooms;
    double roomArea;
    int price;
    double averageRating;

    public Flat(String roomName, String metroStation, String address, int numberOfRooms, double roomArea, int price, double averageRating) {
        this.roomName = roomName;
        this.metroStation = metroStation;
        this.address = address;
        this.numberOfRooms = numberOfRooms;
        this.roomArea = roomArea;
        this.price = price;
        this.averageRating = averageRating;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getMetroStation() {
        return metroStation;
    }

    public String getAddress() {
        return address;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public double getRoomArea() {
        return roomArea;
    }

    public int getPrice() {
        return price;
    }

    public double getAverageRating() {
        return averageRating;
    }

    @Override
    public String toString() {
        return "Наименование: " + roomName + ". Цена = " + price + " руб.. Средняя оценка = " + averageRating + ".";
    }

    public static void menuForApartment() {
        System.out.println("1. Добавить квартиру в список для аренды");
        System.out.println("2. Удалить квартиру из списка для аренды");
        System.out.println("3. Отсортировать квартиры по цене (по возрастанию) и вывести");
        System.out.println("4. Отсортировать квартиры по цене(по убыванию) и вывести");
        System.out.println("5. Сгруппировать квартиры по станции метро и вывести");
        System.out.println("6. Выбрать лучшую квартиру по оценке и вывести");
        System.out.println("7. Вывести изначальный список квартир для аренды. (Порядок в котором они были добавлены)");
        System.out.println("8. Вернутся назад");
    }

    public static void addAnApartment() {
        try {
            System.out.print("Введите название помещения (квартира или коммерческое помещение): ");
            String roomName = console.nextLine();
            System.out.print("Введите станцию метро: ");
            String metroStation = console.nextLine();
            System.out.print("Введите адрес: ");
            String address = console.nextLine();
            System.out.print("Введите кол-во комнат: ");
            int numberOfRooms = console.nextInt();
            console.nextLine();
            System.out.print("Введите площадь помещения: ");
            double roomArea = console.nextInt();
            console.nextLine();
            System.out.print("Введите стоимость помещения: ");
            int price = console.nextInt();
            console.nextLine();
            System.out.print("Оцените помещение от 1 до 10: ");
            double averageRating = console.nextDouble();
            console.nextLine();
            listOfApartments.add(new Flat(roomName, metroStation, address, numberOfRooms, roomArea, price, averageRating));
            System.out.println("SUCCESS. Квартира успешно добавлена.");
        } catch (Exception e) {
            System.out.println("УПС. ЧТО-ТО ПОШЛО НЕ ТАК. Пожалуйста будьте внимательны при заполнении полей.");
        }
    }

    public static void deleteAnApartment() {
        showTheInitialList();
        System.out.print("Введите номер квартиры для удаления: ");
        int choice = console.nextInt();
        console.nextLine();
        if (choice > 0 && choice <= listOfApartments.size()) {
            listOfApartments.remove(choice - 1);
            System.out.println("SUCCESS. Квартира успешно удалена");
        } else System.out.println("ОШИБКА. Квартиры с таким номером не существует");


    }

    public static void sortInAscendingOrder() {
        AtomicInteger count = new AtomicInteger(1);
        listOfApartments.stream().sorted(Comparator.comparing(Flat::getPrice)).forEach(flat -> System.out.println("№" + count.getAndIncrement() + " " + flat.toString()));
    }

    public static void sortInDescendingOrder() {
        AtomicInteger count = new AtomicInteger(1);
        listOfApartments.stream().sorted(Comparator.comparing(Flat::getPrice).reversed()).forEach((flat -> System.out.println("№" + count.getAndIncrement() + " " + flat.toString())));
    }

    public static void groupingByMetroStation() {
        Map<String, List<Flat>> group = listOfApartments.stream().collect(Collectors.groupingBy(Flat::getMetroStation));
        AtomicInteger count = new AtomicInteger(1);
        group.forEach((metro, flat) -> {
            System.out.println(metro);
            flat.forEach(flat1 -> System.out.println("№" + count.getAndIncrement() + " " + flat1.toString()));
        });
    }

    public static void chooseTheBestApartment() {
        System.out.println("THE BEST:");
        listOfApartments.stream().max(Comparator.comparing(Flat::getAverageRating)).ifPresent(System.out::println);
    }

    public static void showTheInitialList() {
        AtomicInteger count = new AtomicInteger(1);
        listOfApartments.forEach((flat -> System.out.println("№" + count.getAndIncrement() + " " + flat.toString())));
    }
}
