package part10_module8;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        boolean bool = true;
        while (bool) {
            try {
                System.out.print("Введите вашу строку: ");
                Check check = new Check(console.nextLine());               //Вводим строку с клавиатуры и сразу же передаём её в конструктор объекта Check.
                check.execute();
            } catch (CheckException e) {
                System.out.print(e.getMessage());
                System.out.println(e.getSymbol());
                bool = false;
            }
        }
    }
}