package part16_project3;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class CommercialPremises {

    static Scanner console = new Scanner(System.in);
    public static List<CommercialPremises> listOfCommercialPremises = new ArrayList<>();
    String roomName;
    String metroStation;
    String address;
    String typeOfRoom;
    double roomArea;
    int price;
    double averageRating;

    public CommercialPremises(String roomName, String metroStation, String address, String typeOfRoom, double roomArea, int price, double averageRating) {
        this.roomName = roomName;
        this.metroStation = metroStation;
        this.address = address;
        this.typeOfRoom = typeOfRoom;
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

    public String getTypeOfRoom() {
        return typeOfRoom;
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

    public static void menuForCommercialPremises() {
        System.out.println("1. Добавить коммерческое помещение в список для аренды");
        System.out.println("2. Удалить помещение из списка для аренды");
        System.out.println("3. Отсортировать помещения по цене (по возрастанию) и вывести");
        System.out.println("4. Отсортировать помещения по цене(по убыванию) и вывести");
        System.out.println("5. Сгруппировать помещения по станции метро и вывести");
        System.out.println("6. Выбрать лучшее помещение по оценке и вывести");
        System.out.println("7. Вывести изначальный список коммерческих помещений для аренды. (Порядок в котором они были добавлены)");
        System.out.println("8. Вернутся назад");
    }

    public static void addCommercialPremises() {
        try {
            System.out.print("Введите название помещения (квартира или коммерческое помещение): ");
            String roomName = console.nextLine();
            System.out.print("Введите станцию метро: ");
            String metroStation = console.nextLine();
            System.out.print("Введите адрес: ");
            String address = console.nextLine();
            System.out.print("Введите тип помещения: ");
            String typeOfRoom = console.nextLine();
            System.out.print("Введите площадь помещения: ");
            double roomArea = console.nextInt();
            console.nextLine();
            System.out.print("Введите стоимость помещения: ");
            int price = console.nextInt();
            console.nextLine();
            System.out.print("Оцените помещение от 1 до 10: ");
            double averageRating = console.nextDouble();
            console.nextLine();
            listOfCommercialPremises.add(new CommercialPremises(roomName, metroStation, address, typeOfRoom, roomArea, price, averageRating));
            System.out.println("SUCCESS. Коммерческое помещение успешно добавленно.");
        } catch (Exception e) {
            System.out.println("УПС. ЧТО-ТО ПОШЛО НЕ ТАК. Пожалуйста будьте внимательны при заполнении полей.");
        }
    }

    public static void deleteCommercialPremises() {
        showTheInitialList();
        System.out.print("Введите номер коммерческого помещения для удаления: ");
        int choice = console.nextInt();
        console.nextLine();
        if (choice > 0 && choice <= listOfCommercialPremises.size()) {
            listOfCommercialPremises.remove(choice - 1);
            System.out.println("SUCCESS. Коммерческое помещение успешно удалено");
        } else System.out.println("ОШИБКА. Коммерческого помещения с таким номером не существует");


    }

    public static void sortInAscendingOrder() {
        AtomicInteger count = new AtomicInteger(1);
        listOfCommercialPremises.stream().sorted(Comparator.comparing(CommercialPremises::getPrice)).forEach(flat -> System.out.println("№" + count.getAndIncrement() + " " + flat.toString()));
    }

    public static void sortInDescendingOrder() {
        AtomicInteger count = new AtomicInteger(1);
        listOfCommercialPremises.stream().sorted(Comparator.comparing(CommercialPremises::getPrice).reversed()).forEach((flat -> System.out.println("№" + count.getAndIncrement() + " " + flat.toString())));
    }

    public static void groupingByMetroStation() {
        Map<String, List<CommercialPremises>> group = listOfCommercialPremises.stream().collect(Collectors.groupingBy(CommercialPremises::getMetroStation));
        AtomicInteger count = new AtomicInteger(1);
        group.forEach((metro, commercialPremises) -> {
            System.out.println(metro);
            commercialPremises.forEach(comPremises -> System.out.println("№" + count.getAndIncrement() + " " + comPremises.toString()));
        });
    }

    public static void chooseTheBestApartment() {
        System.out.println("THE BEST:");
        listOfCommercialPremises.stream().max(Comparator.comparing(CommercialPremises::getAverageRating)).ifPresent(System.out::println);
    }

    public static void showTheInitialList() {
        AtomicInteger count = new AtomicInteger(1);
        listOfCommercialPremises.forEach((comPremises -> System.out.println("№" + count.getAndIncrement() + " " + comPremises.toString())));
    }
}
