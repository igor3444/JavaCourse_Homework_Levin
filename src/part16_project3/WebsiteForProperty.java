package part16_project3;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.DoubleToIntFunction;

public class WebsiteForProperty {

    Scanner console = new Scanner(System.in);

    public void startWebsite() {
        while (true) {
            generalMenu1();
        }
    }

    public void generalMenu1() {
        while (true) {
            try {
                System.out.println("1. Перейти в раздел с квартирами");
                System.out.println("2. Перейти в раздел с коммерческими помещениями");
                System.out.println("3. Удалить всё из списков");
                System.out.println("4. Вывести сгруппированные списки");
                System.out.println("5. Покинуть сайт");
                int choice = console.nextInt();
                console.nextLine();
                if (choice == 1) {
                    selectAnActionWithApartment();
                    break;
                } else if (choice == 2) {
                    selectAnActionWithCommercialPremises();
                    break;
                } else if (choice == 3) {
                    Flat.listOfApartments.clear();
                    CommercialPremises.listOfCommercialPremises.clear();
                    System.out.println("SUCCESS. Списки очищены.");
                    System.out.println();
                } else if (choice == 4) {
                    System.out.println("Квартиры:");
                    AtomicInteger countFlat = new AtomicInteger(1);
                    Flat.listOfApartments.forEach((flat -> System.out.println("№" + countFlat.getAndIncrement() + " " + flat.toString())));
                    System.out.println("Коммерческая недвижимость:");
                    AtomicInteger countCom = new AtomicInteger(1);
                    CommercialPremises.listOfCommercialPremises.forEach((comPremises -> System.out.println("№" + countCom.getAndIncrement() + " " + comPremises.toString())));
                    System.out.println();
                } else if (choice == 5)
                    System.exit(0);
                else {
                    System.out.println("Извините такого варианта не существует попробуйте снова");
                    continue;
                }
            } catch (Exception e) {
                console.nextLine();
                System.out.println("УПС. ЧТО-ТО ПОШЛО НЕ ТАК. Пожалуйста будьте внимательны при заполнении полей.");
                System.out.println();
            }
        }
    }

    public void selectAnActionWithApartment() {
        while (true) {
            try {
                System.out.println();
                Flat.menuForApartment();
                int choice = console.nextInt();
                console.nextLine();
                if (choice == 1) {
                    Flat.addAnApartment();
                } else if (choice == 2) {
                    Flat.deleteAnApartment();
                } else if (choice == 3) {
                    Flat.sortInAscendingOrder();
                } else if (choice == 4) {
                    Flat.sortInDescendingOrder();
                } else if (choice == 5) {
                    Flat.groupingByMetroStation();
                } else if (choice == 6) {
                    Flat.chooseTheBestApartment();
                } else if (choice == 7) {
                    Flat.showTheInitialList();
                } else if (choice == 8) {
                    break;
                } else System.out.println("ОШИБКА. Такого варианты к сожалению нету, попробуйте ещё раз");
            } catch (Exception e) {
                console.nextLine();
                System.out.println("УПС. ЧТО-ТО ПОШЛО НЕ ТАК. Пожалуйста будьте внимательны при заполнении полей.");
            }
        }
    }

    public void selectAnActionWithCommercialPremises() {
        while (true) {
            System.out.println();
            CommercialPremises.menuForCommercialPremises();
            int choice = console.nextInt();
            console.nextLine();
            if (choice == 1) {
                CommercialPremises.addCommercialPremises();
            } else if (choice == 2) {
                CommercialPremises.deleteCommercialPremises();
            } else if (choice == 3) {
                CommercialPremises.sortInAscendingOrder();
            } else if (choice == 4) {
                CommercialPremises.sortInDescendingOrder();
            } else if (choice == 5) {
                CommercialPremises.groupingByMetroStation();
            } else if (choice == 6) {
                CommercialPremises.chooseTheBestApartment();
            } else if (choice == 7) {
                CommercialPremises.showTheInitialList();
            } else if (choice == 8) {
                break;
            } else System.out.println("ОШИБКА. Такого варианта к сожалению нету, попробуйте ещё раз");
        }
    }
}
