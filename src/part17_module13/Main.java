package part17_module13;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try (FileReader fr = new FileReader("file.txt");
             FileWriter fw = new FileWriter("file2.txt");
             BufferedReader br = new BufferedReader(fr);
             BufferedWriter bw = new BufferedWriter(fw)
        ) {


            StringBuilder str = new StringBuilder();
            int i;
            while ((i = br.read()) != -1) {
                str.append((char) i);
            }

            String strAfter1 = str.toString();
            strAfter1 = strAfter1.replaceAll("[.!?\\-,:;()]", "");                              //Убираем все знаки препинания
            String strAfter2 = strAfter1.toLowerCase();                                                         //Переводим все символы в нижний регистр и в дальнейшем используем эту переменную для создания конструктора

            List<String> listBigWords = new ArrayList<>(Arrays.asList(strAfter1.split(" ")));             //Разбиваем строку по пробелам, возвраащем массив подстрок и записываем их в список
            List<String> wordsToRemove = new ArrayList<>();

            for (String value : listBigWords) {
                if (value.length() <= 6) {                                                                      //Слова в которых 6 и менее символов добавляем во второй список
                    wordsToRemove.add(value);
                }
            }
            listBigWords.removeAll(wordsToRemove);                                                              //И теперь удаляем из нашего списка слова в которых 6 и менее символов

            TemporarySample tempSamp = new TemporarySample(strAfter2, listBigWords);                           //Создали экземпляр класса

            str.replace(0, (str.length() - 1), strAfter2);
            str.append(" ");
            str.append(listBigWords);
            bw.write(str.toString());                                                                          //Записываем весь иземённый текст в новый файл file2.txt

            System.out.println(tempSamp.getText());
            System.out.println(tempSamp.getBigWords());

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
