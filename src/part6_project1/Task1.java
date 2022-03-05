package part6_project1;

import java.util.Scanner;

public class Task1 {
    public static Scanner console = new Scanner(System.in);
    public static int num1;
    public static int num2;
    public static int output;
    public static String[] array = new String[3];
    public static int countForComparison = 1;                 //Счётчик для операции сравнения. Если мы выберем операцию сравнения, то 2-й пункт меню в след. витке будет не доступен

    public static void main(String[] args) {
        int count = 1;

        while (true) {                                         //Заходим в цикл

            menu_1();                                          //Показываем первое меню пользователю

            int choice = console.nextInt();                    //Пользователь выбирает один из трёх вариантов
            console.nextLine();                                // С помощью этой команды убираем \n в конце строки
            if (choice == 1) {
                System.out.println("Введите пример в формате 'n + n'");
                String inputString = console.nextLine();                 //Пользователь выбрал первый пункт и ему разрешается ввести пример по шаблону "n + n" или "n !"

                boolean bool1 = Check.checkExample1(inputString);        //Здесь мы проверям ввёл ли пользователь пример согласно шаблону
                if (bool1) {
                    split(inputString);                                  //Разбиваем пример на элементы и присваем массиву
                    num1 = inTheNumber(array[0]);                        //Преобразуем тип String в int
                    num2 = inTheNumber(array[2]);
                    countForComparison = 1;
                    SolutionAndConclusion(array[1], num1, num2);         //Выводим результат вычислений
                } else System.out.println("Вы ввели пример в неверном формате. Попробуйте повторить снова");
            } else if (choice == 2 && count != 1 && countForComparison == 1) {
                menu_2();                                                //Показываем второе меню пользователю
                String choice2 = console.nextLine();                     //Пользователь с помощью соответствующих цифр выбирает необходимую операцию: "+" "-" "*" "/" "!" "^" "?" "назад"
                int intChoice2 = inTheNumber(choice2);
                if (intChoice2 >= 1 && intChoice2 <= 7 && intChoice2 != 5) {                   //Если пользователь вводит цифру от 1 до 7 то мы заходим в условие. Иначе мы считаем что пользователь ввёл "0". Также если пользователь вычисляет факториал, то второе число ему вводить не предлагается.
                    System.out.print("Введите второе число для дальнейших вычислений: ");
                    String inputString = console.nextLine();                                   //Ввод второго числа (первое число output уже ожидает в памяти)
                    num2 = inTheNumber(inputString);
                }
                SolutionAndConclusion(choice2, output, num2);            //Выводим результат вычислений
            } else if (choice == 3) {
                break;
            } else if (choice == 2 && count == 1) {
                System.out.println("Недоступно");
                count--;                                                 //Уменьшаем count чтобы во втором витке цикла мы не смогли выбрать второй пункт т.к. у нас по прежнему отсутствует первое число
            }
            else if (countForComparison == 2) {
                System.out.println("После операции сравнения второй пункт к сожалению не доступен:(");
            }
            count++;
        }
    }

    public static void menu_1() {
        System.out.println("1. Ввести пример.");
        System.out.println("2. Продолжить работать с предыдущим ответом");
        System.out.println("3. Выход");
    }

    public static void menu_2() {
        System.out.println("1. Сложение");
        System.out.println("2. Вычитание");
        System.out.println("3. Умножение");
        System.out.println("4. Деление");
        System.out.println("5. Факториал");
        System.out.println("6. Возведение в степень");
        System.out.println("7. Сравнение");
        System.out.println("0. Назад");
    }
    public static void split (String str) {
        String[] arrayTemp = str.split(" ");
        if (arrayTemp.length == 3)
            array = arrayTemp;
        else if (arrayTemp.length == 2) {
            array[0] = arrayTemp[0];
            array[1] = arrayTemp[1];
            array[2] = "0";                               //Третьему элементу массива присваиваем ноль т.к. при вычислении факториала, мы подаём два чила на вход, вместо трёх
        }
    }

    public static int inTheNumber (String array_i) {
        return Integer.parseInt(array_i);
    }
    public static void SolutionAndConclusion (String sign, int num1, int num2) {
        char signChar  = sign.charAt(0);
        switch (signChar) {
            case ('\u002b'):                    // +
            case ('\u0031'):                    // 1
                sum(num1, num2);
                break;

            case ('\u002d'):                    // -
            case ('\u0032'):                    // 2
                subtraction(num1, num2);
                break;

            case ('\u002a'):                    // *
            case ('\u0033'):                    // 3
                multiplication(num1, num2);
                break;

            case ('\u002f'):                    // Деление
            case ('\u0034'):                    // 4
                division(num1, num2);
                break;

            case ('\u0021'):                    // !
            case ('\u0035'):                    // 5
                factorialOutput(num1);
                break;

            case ('\u005e'):                    // ^
            case ('\u0036'):                    // 6
                exponentiation(num1, num2);
                break;

            case ('\u003f'):                    // ?
            case ('\u0037'):                    // 7
                comparison(num1, num2);
                break;

            case ('\u0030'):                    // 0
                break;
        }

    }

    public static void sum(int num1, int num2) {
        output = num1 + num2;
        System.out.println("\"+\" - " + num1 + " + " + num2 + " = " + output);
    }

    public static void subtraction (int num1, int num2) {
        output = num1 - num2;
        System.out.println("\"-\" - " + num1 + " - " + num2 + " = " + output);
    }

    public static void multiplication(int num1, int num2) {
        output = num1 * num2;
        System.out.println("\"*\" - " + num1 + " * " + num2 + " = " + output);
    }

    public static void division(int num1, int num2) {
        output = num1 / num2;
        System.out.println("\"/\" - " + num1 + " / " + num2 + " = " + output);
    }

    public static void factorialOutput(int num1) {
        output = factorial(num1);
        System.out.print("\"!\" - " + num1 + " = ");
        for (int i = num1; i > 0; i--) {
            System.out.print(i + " * ");
        }
        System.out.println("\b\b\b = " + output);
    }

    public static int factorial (int num1) {
        if (num1 <= 1) return 1;
        return num1 * factorial(num1  - 1);
    }

    public static void exponentiation(int num1, int num2) {
        output = (int) Math.pow(num1, num2);
        System.out.println("\"^\" - " + num1 + " ^ " + num2 + " = " + output);
    }

    public static void comparison(int num1, int num2) {
        if (num1 > num2)
            System.out.println("\"?\" - " + num1 + " ? " + num2 + " = " + num1 + " > " + num2);
        else
            System.out.println("\"?\" - " + num1 + " ? " + num2 + " = " + num1 + " < " + num2);
        countForComparison++;
    }
}