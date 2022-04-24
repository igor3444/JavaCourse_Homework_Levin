package part14_module11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        StringBuilder strB1 = new StringBuilder();

        System.out.println("Вы ввели: ");
        strB1.append("Меня зовут Игорь. Мой номер телефона: +79616607808. Моя электронная почта: lev.iigor2017@yandex.ru");     //Ложим строку в наш стрингбилдер
        strB1.insert(17, " Мне 24 года.");
        System.out.println(strB1);

        Pattern p = Pattern.compile("\\+\\d{11}");
        Matcher m = p.matcher(strB1);

        String substr1;
        String substr2;
        String substr3;
        if (m.find()) {                                                    //возвращает true, если в строке есть подстрока, которая совпадает с шаблоном, и переходит к этой подстроке
            substr1 = m.group();                                           //возвращает подстроку, которая совпала с шаблоном в результате вызова метода find
            substr2 = substr1.substring(3, 10);                            //В эту переменную записываем подстроку, которую буем изменять на ***
            substr3 = substr1.replace(substr2, "*******");
            strB1.replace(m.start(), m.end(), substr3);                    //Присваиваем нашему срингбилдеру изменённую подстроку
        }

        p = Pattern.compile("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}");
        m = p.matcher(strB1);
        if (m.find()) {
            substr1 = m.group();
            substr2 = substr1.substring(2, 15);
            substr3 = substr1.replace(substr2, "*********");
            strB1.replace(m.start(), m.end(), substr3);
        }
        System.out.println("Отформатированный вывод: ");
        System.out.println(strB1);

        p = Pattern.compile("\\d{2}");                                          //Выводим подстрокив  которых 2 цифры
        m = p.matcher(strB1);

        while (m.find()) {
            substr1 = m.group();
            System.out.println(substr1);
        }
    }
}
