package part3_module2;

import java.util.Scanner;
public class Task4 {

    public static void main(String[] args) {

        System.out.println("С клавиатуры вводится двумерный массив, длина его строк – 4, столбцов – 3.");
        Scanner console = new Scanner(System.in);
        int[][] array = new int[console.nextInt()][console.nextInt()];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = console.nextInt();
            }
        }

// 1.Напишите программу, которая выводит номера строк и суммы их элементов (пример: Line 2: 17).
        System.out.println("1.Напишите программу, которая выводит номера строк и суммы их элементов (пример: Line 2: 17).");

        for (int i = 0; i < array.length; i++) {
            int sum = array[i][0];
            for (int j = 1; j < array[i].length; j++) {
                sum += array[i][j];
            }
            System.out.println("Line " + (i + 1) + ": " + sum);
        }

// 2.Напишите программу, которая выводит номера столбцов и суммы их элементов (пример: Column 3: 21).
        System.out.println("2.Напишите программу, которая выводит номера столбцов и суммы их элементов (пример: Column 3: 21).");

        for (int j = 0; j < array[j].length; j++) {
            int sum = array[0][j];
            for (int i = 1; i < array.length; i++) {
                sum += array[i][j];
            }
            System.out.println("Column" + (j + 1) + ": " + sum);
        }

// 3.Напишите программу, которая заменяет все нечётные элементы массива на 1, а чётные на 0 и выводит его на экран.
        System.out.println("3.Напишите программу, которая заменяет все нечётные элементы массива на 1, а чётные на 0 и выводит его на экран.");
/*
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if ((array[i][j] % 2) != 0)
                    array[i][j] = 1;
                else
                    array[i][j] = 0;
                System.out.print(array[i][j] + ", ");
            }
            System.out.println("\b\b");
        }
*/
// 4.Напишите программу, которая для в каждой строке находит целое среднее арифметическое и выводит его на экран.
        System.out.println("4.Напишите программу, которая для в каждой строке находит целое среднее арифметическое и выводит его на экран.");

        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }
            double avg = sum * 1.0 / array[i].length;
            System.out.println("Average" + (i + 1) + ": " + avg);
        }

// 5.***Напишите программу, которая преобразует двумерный массив в перевёрнутый одномерный и выводит все элементы одномерного массива на экран.
        System.out.println("5.***Напишите программу, которая преобразует двумерный массив в перевёрнутый одномерный и выводит все элементы одномерного массива на экран.");

        int[] resultArray = new int[array.length * array[0].length];
        int count = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = array[i].length -1; j >= 0; j--) {
                resultArray[count] = array[i][j];
                count++;
            }
        }
        for (int i = 0; i < resultArray.length; i++) {
            System.out.print(resultArray[i] + " ");
        }
    }
}
