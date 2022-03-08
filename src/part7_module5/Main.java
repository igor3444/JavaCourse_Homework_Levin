package part7_module5;

public class Main {

    public static void main(String[] args) {

        BMW bmw = new BMW(200, 350.5f, "жёлтый", "ноздри");
        Audi audi = new Audi(250, 440.3f, "чёрный", "качество");
        Mercedes mercedes = new Mercedes(150, 95.5f, "красный", "статус");

        System.out.println(bmw.getFeature());
        System.out.println(bmw.getBmwHistory());
        bmw.specifications();
        bmw.rating = 11;
        System.out.println("- Рейтинг БМВ в 2020 году: " + bmw.rating + "\n");


        System.out.println(audi.getFeature());
        System.out.println(audi.getAudiHistory());
        audi.specifications();
        audi.rating = 13;
        System.out.println("- Рейтинг Ауди в 2020 году: " + audi.rating + "\n");

        System.out.println(mercedes.getFeature());
        System.out.println(mercedes.getMercedesHistory());
        mercedes.specifications();
        mercedes.rating = 10;
        System.out.println("- Рейтинг Мерсдес в 2020 году: " + bmw.rating);
    }
}
