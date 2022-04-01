package part10_module8;

public class Check {
    String console;

    public Check(String console) {
        this.console = console;
    }

    public void execute() throws CheckException {
        String[] arrays = console.split("");

        for(String array : arrays) {
            try {
                int a = Integer.parseInt(array);                                                  //Если символ строки получилось перевести в число, мы создаём новое исключение.
                throw new CheckException("В вашей строке присутствует цифра: ", array);           //В противном случае, мы получаем исключение NumberFormatException, которое для нас является ожидаемым результатом и нас не интересует.
            } catch (NumberFormatException ignored) {
            }
        }

        for (int i = 0; i < arrays.length - 2; i++) {
            if (arrays[i].equals(arrays[i + 1]) && arrays[i].equals(arrays[i + 2]))                                      //Проверка на три одинаковые бувы подряд
                throw new CheckException("В вашей строке присутствуют 3 одинаковые буквы подряд: ", arrays[i]);
        }
    }
}
