package part3_module2;

public class Task3 {

    public static void main (String[] args) {

        int [] array = {3, 22, 1, 13, 4, 6, 16, 5};

// 1.Напишите программу, которая выводит (через пробел) те элементы массива, которые являются чётными числами.
        System.out.print("1. ");
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 ==0)
                System.out.print(array[i] + ", ");
        }
// 2.Напишите программу, которая выводит все двузначные числа массива.
        System.out.print("\b\b\n2. ");
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 9)
                System.out.print(array[i] + ", ");
        }
// 3.Напишите программу, которая выводит на экран наибольшее целое число этого массива.
        System.out.print("\b\b\n3. ");
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }
        System.out.print(max + "\n4. ");
// 4.Напишите программу, которая считает сумму элементов массива и выводит её на экран.
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            sum += array[i];
        }
        System.out.print(sum + "\n5. ");
// 5.***Напишите программу, которая переворачивает массив в обратном порядке.
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] =array[array.length - i -1];
            array[array.length - i - 1] = temp;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
    }
}