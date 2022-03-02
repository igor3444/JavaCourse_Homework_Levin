package part4_module3;

import java.util.Scanner;

public class Task {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();

        String[] array = split(input);
        int number = inTheNumber(array[1]);
        int sumDigits = sumDigits(number);
        output(array[0], sumDigits);
    }

    public static String[] split(String input) {
        return input.split(" ");
    }

    public static int inTheNumber(String str) {
        return Integer.parseInt(str);
    }

    public static int sumDigits(int number) {
        if (number < 10) return number;
        return number % 10 + sumDigits(number / 10);
    }

    public static void output(String name, int sumDigits) {
        String[] Below_eleven = {"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять"};
        if (sumDigits > 10)
            System.out.println("Извините, введённое вами число слишком большое. Попробуйте ввести число поменьше");
        else if (sumDigits < 0)
            System.out.println("Вы ввели число со знаком минус. Извините, я не умею считать сумму отрицательных чисел, возможно в будущем научусь. Заходите через месяц)");
        else
            System.out.println("Здравствуйте " + name + "! Сумма цифр в числе = " + Below_eleven[sumDigits]);
    }
}
