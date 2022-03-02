package part2_module1;

public class Task2 {
    public static void main (String[] args) {
        number1("Moscow", 17_000_000, (float) 0.66);
        number2((char) 97, (short) 8, 3_500);
        number3("Игорь", (short)23, (short) 176);
        number4((char) 65, (byte) 0, 1_465);
        number5("ООО Ашан", 1_000_000_000, 10.2);
        number6('\u0052', '\u0068', (byte) 3, 11);
        number7("MADI", 20_000, 50);
        number8('\u2665', 567, 9);
        number9("LouisVuitton", 3_576_241, 13);
        number10('\u26F7', 1223486, 30);
    }
    public static void number1 (String city, int population, float unemployed) {
        System.out.printf("1. City: %s; Population: %d; Unemployed: %.2f;", city, population, unemployed);
        System.out.println();
    }
    public static void number2 (char section, short place, int cost) {
        System.out.printf("2. Section: %c; Place: %d; Cost: %d;", section, place, cost);
        System.out.println();
    }
    public static void number3 (String name, short age, short height) {
        System.out.printf("3. Name: %s; Age: %d; Height: %d;", name, age, height);
        System.out.println();
    }
    public static void number4 (char letters, byte numbers, int weight) {
        System.out.printf("4. CarNumber: %s%d%d%d%s%s; Weight: %d;", letters, numbers, numbers, numbers, letters, letters, weight);
        System.out.println();
    }
    public static void number5 (String name, long AnnualIncome, double MarketShare) {
        System.out.printf("5. Name: %s; AnnualIncome: %d; MarketShare: %.1f;", name, AnnualIncome, MarketShare);
        System.out.println();
    }
    public static void number6 (char RhFactor1, char RhFactor2, byte BloodType, double ProportionOfPeople) {
        System.out.printf("6. RhFactor: %c%c; BloodType: %d; ProportionOfPeople: %.1f;", RhFactor1, RhFactor2, BloodType, ProportionOfPeople);
        System.out.println();
    }
    public static void number7 (String name, int number, double losers) {
        System.out.printf("7. Name: %s; Number: %d; Losers: %.1f;", name, number, losers);
        System.out.println();
    }
    public static void number8 (char rating1, int copies, double rating2) {
        System.out.printf("8. Rating: %c; Copies: %d; Rating: %.1f;", rating1, copies, rating2);
        System.out.println();
    }
    public static void number9 (String name, int number, double percent) {
        System.out.printf("9. Name: %s; Quantity: %d; Percent: %.1f;", name, number, percent);
        System.out.println();
    }
    public static void number10 (char category, int barcode, double percent) {
        System.out.printf("10. Category: %c; Barcode: %d; Percent: %.1f;", category, barcode, percent);
        System.out.println();
    }
}
