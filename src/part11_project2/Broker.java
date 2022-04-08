package part11_project2;

import java.util.Scanner;

public class Broker {

    Quotes[] quotes = new Quotes[2];
    int numQuotes = 0;
    News[] news = new News[2];
    int numNews = 0;
    Booklist[] booklists = new Booklist[2];
    int numBooklist = 0;
    ActionWithNotes actionWithNotes;
    Scanner console = new Scanner(System.in);

    Role username;

    public void authorization() {
        username = null;
        boolean bool = true;
        while (bool) {
            System.out.print("Введите логин: ");
            String enteredLogin = console.nextLine();
            System.out.print("Введите пароль: ");
            String enteredPassword = console.nextLine();
            Role[] roles = Role.values();
            for (int i = 0; i < roles.length; i++) {
                if (enteredLogin.equals(roles[i].getLogin())) {                                         //Введённый нами логин на предыдущих этапах сравнивается с теми логинами которые хранятся в системе
                    if (enteredPassword.equals(roles[i].getPassword())) {                               //Сравнивается введённый пароль с паролем из базы данных, который принадлежит введенному логину.
                        bool = false;
                        username = roles[i];
                        break;
                    } else {
                        System.out.println("Неверный пароль. Выберите дальнейшее действие:");
                        boolean a = true;
                        while (a) {
                            try {
                                System.out.println("1. Попробовать авторизоваться еще раз.");
                                System.out.println("2. Я нуб, забыл пароль и хочу завершить программу");
                                int input = console.nextInt();
                                console.nextLine();
                                if (input == 1) {
                                    a = false;
                                } else if (input == 2) {
                                    System.exit(0);
                                } else {
                                    System.out.println("Извини кожанный, но такого вараинта не было");
                                }
                            } catch (Exception b) {
                                System.out.println("Что-то пошло не так. При вводе используйте только цифры");
                            }
                        }
                        break;
                    }
                } else if (i == roles.length - 1) {                                                       //Если не один логин из базы данных не соответствует введённому логину
                    System.out.println("Неверный логин. Выберите дальнейшее действие:");                     //То на последней итерации цикла выводим пользователю сообщение о неверном логине.
                    boolean b = true;
                    while (b) {
                        try {
                            System.out.println("1. Попробовать авторизоваться еще раз.");
                            System.out.println("2. Я забыл логин и хочу завершить программу");
                            int input = console.nextInt();
                            console.nextLine();
                            if (input == 1) {
                                b = false;
                            } else if (input == 2) {
                                System.exit(0);
                            } else {
                                System.out.println("Извини кожанный, но такого варианта не было");
                            }
                        } catch (Exception a) {
                            System.out.println("Что-то пошло не так. При вводе используйте только цифры");
                            console.nextLine();
                        }
                    }
                }
            }
        }
    }

    int numNote = 1;                                                                    //Эта переменная нам нужна чтобы нумеровать наши заметки

    public void creatingNote() {
        boolean bool = true;
        while (bool) {
            try {
                System.out.println("Выберите тип создаваемой заметки: ");
                System.out.println("1. Цитаты");
                System.out.println("2. Новости");
                System.out.println("3. Список книг");
                System.out.println("4. Вернутся на главную сраницу");
                int choice = console.nextInt();                                                //Выбираем тип заметки
                console.nextLine();
                if (choice == 1) {
                    if (numQuotes < quotes.length) {
                        quotes[numQuotes] = new Quotes();                          //Создаём новую цитату
                        quotes[numQuotes].creatingNote();
                        quotes[numQuotes].setNumNote(numNote);
                        numNote++;
                        numQuotes++;
                        System.out.println("Заметка успешно создана. Вы можете продолжить создание заметок или же покинуть данный раздел");
                        bool = true;
                    } else
                        System.out.println("Блок с памятью под цитаты переполнен. Попробуйте выбрать заметку друго типа!");
                } else if (choice == 2) {
                    if (numNews < news.length) {
                        news[numNews] = new News();
                        news[numNews].creatingNote();
                        news[numNews].setNumNote(numNote);
                        numNote++;
                        numNews++;
                        System.out.println("Заметка успешно создана. Вы можете продолжить создание заметок или же покинуть данный раздел");
                        bool = true;
                    } else
                        System.out.println("Блок с памятью под новости переполнен. Попробуйте выбрать заметку друго типа!");
                } else if (choice == 3) {
                    if (numBooklist < booklists.length) {
                        booklists[numBooklist] = new Booklist();
                        booklists[numBooklist].creatingNote();
                        booklists[numBooklist].setNumNote(numNote);
                        numNote++;
                        numBooklist++;
                        System.out.println("Заметка успешно создана. Вы можете продолжить создание заметок или же покинуть данный раздел");
                        bool = true;
                    } else
                        System.out.println("Блок с памятью под книги переполнен. Попробуйте выбрать заметку друго типа!");
                } else if (choice == 4) {
                    bool = false;
                } else {
                    System.out.println("Такого раздела не существует. Попробуйте ещё раз!");
                }
            } catch (Exception a) {
                System.out.println("Что-то пошло не так. При вводе используйте только цифры");
                console.nextLine();
            }
        }
    }

    public boolean Search() {
        boolean bool1 = true;
        while (bool1) {
            System.out.print("Для поиска введите название заметки: ");
            String title = console.nextLine();

            if (SearchLogic(title) != null)
                System.out.println(SearchLogic(title).toString());
            else System.out.println("Совпадений не найдено");

            boolean bool2 = true;
            while (bool2) {
                try {
                    System.out.println("1. Продолжить поиск");
                    System.out.println("2. Выбрать найденную заметку для дальнейших действий");
                    System.out.println("3. Вернутся на главную страницу");
                    int num = console.nextInt();
                    console.nextLine();
                    if (num == 1) {
                        bool1 = true;
                        bool2 = false;
                    } else if (num == 2) {
                        return true;
                    } else if (num == 3) {
                        bool1 = false;
                        bool2 = false;
                    } else {
                        System.out.println("Такого варианта нет. Выберите пункт из предложенного списка");
                    }
                } catch (Exception b) {
                    System.out.println("Что-то пошло не так. При вводе используйте только цифры");
                    console.nextLine();
                }
            }
        }
        return false;
    }

    public <T> T SearchLogic(String title) {
        middleQuote = null;
        middleNews = null;
        middleBooklist = null;
        for (Quotes quote : quotes) {
            actionWithNotes = quote;
            try {
                if (actionWithNotes.noteSearch(title)) {
                    middleQuote = quote;
                    return (T) quote;
                }
            } catch (NullPointerException a) {                                               //обработка исключения, в тот момент когда цикл натыкается на пустой элемент массива
                break;
            }
        }
        for (News new_ : news) {
            actionWithNotes = new_;
            try {
                if (actionWithNotes.noteSearch(title)) {
                    middleNews = new_;
                    return (T) new_;
                }
            } catch (NullPointerException a) {
                break;
            }
        }
        for (Booklist booklist : booklists) {
            actionWithNotes = booklist;
            try {
                if (actionWithNotes.noteSearch(title)) {
                    middleBooklist = booklist;
                    return (T) booklist;
                }
            } catch (NullPointerException a) {
                break;
            }
        }
        return null;
    }


    int sumNote = 0;                                                                    //Переменная для подсчета общего кол-ва заметок

    public boolean showList() {
        boolean bool1 = true;
        while (bool1) {
            for (Quotes quote : quotes) {
                if (quote != null) {
                    System.out.println(quote.toString());
                    sumNote++;
                } else break;
            }
            for (News new_ : news) {
                if (new_ != null) {
                    System.out.println(new_.toString());
                    sumNote++;
                } else break;
            }
            for (Booklist booklist : booklists) {
                if (booklist != null) {
                    System.out.println(booklist.toString());
                    sumNote++;
                } else break;
            }
            boolean bool2 = true;
            while (bool2) {
                try {
                    System.out.println("1. Выбрать заметку для дальнейшей работы с ней");
                    System.out.println("2. Вернутся на главную странцу");
                    int num = console.nextInt();
                    console.nextLine();
                    if (num == 1) {
                        return selectNote();                                                           //-> ВХОД в другой метод. Он передаёт булевое значение из метода selectNote в main
                    } else if (num == 2) {
                        bool1 = false;
                        bool2 = false;
                    } else {
                        System.out.println("Такого варианта нет. Выберите пункт из предложенного списка");
                    }
                } catch (Exception b) {
                    System.out.println("Что-то пошло не так. При вводе используйте только цифры");
                    console.nextLine();
                }
            }
        }
        return false;
    }

    int index;
    Quotes middleQuote;
    News middleNews;
    Booklist middleBooklist;

    public boolean selectNote() {
        middleQuote = null;                                                                              //Перед выбором обнуляем наши переменные, в одну из которых в дальнейшем запишется ссылка на заметку
        middleNews = null;
        middleBooklist = null;
        boolean bool1 = true;
        int counter = 0;
        while (bool1) {
            try {
                System.out.print("Введите номер заметки: ");
                int inputNumNote = console.nextInt();
                console.nextLine();
                if (inputNumNote <= sumNote) {                                                              // Введенный номер заметки должен быть <= общему кол-ву заметок
                    for (int i = 0; i < quotes.length; i++) {
                        if (quotes[i] != null && quotes[i].getNumNote() == inputNumNote) {
                            System.out.println(quotes[i].toString());
                            middleQuote = quotes[i];
                            index = i;
                            return true;
                        }
                    }
                    for (int a = 0; a < news.length; a++) {
                        if (news[a] != null && news[a].getNumNote() == inputNumNote) {
                            System.out.println(news[a].toString());
                            middleNews = news[a];
                            index = a;
                            return true;
                        }
                    }
                    for (int b = 0; b < booklists.length; b++) {
                        if (booklists[b] != null && booklists[b].getNumNote() == inputNumNote) {
                            System.out.println(booklists[b].toString());
                            middleBooklist = booklists[b];
                            index = b;
                            return true;
                        }
                    }
                } else {
                    System.out.println("Заметки с таким номером не существует");
                }
            } catch (Exception a) {
                System.out.println("Что-то пошло не так. При вводе используйте только цифры");
                console.nextLine();
                continue;
            }
            boolean bool2 = true;
            while (bool2) {
                try {
                    System.out.println("1. Попробовать еще раз");
                    System.out.println("2. Вернутся на главную старницу");
                    int num = console.nextInt();
                    console.nextLine();
                    if (num == 1) {
                        bool2 = false;
                    } else if (num == 2) {
                        return false;
                    } else {
                        System.out.println("Такого варианта нет. Выберите пункт из предложенного списка");
                    }
                } catch (Exception b) {
                    System.out.println("Что-то пошло не так. При вводе используйте только цифры");
                    console.nextLine();
                }
            }
        }
        return false;
    }


    public void deleteNote() {
        if (middleQuote != null) {
            sortingAfterDelete(1);
            sumNote--;
            numQuotes--;
            numNote--;
        }
        if (middleNews != null) {
            sortingAfterDelete(2);
            sumNote--;
            numNews--;
            numNote--;
        }
        if (middleBooklist != null) {
            sortingAfterDelete(3);
            sumNote--;
            numBooklist--;
            numNote--;
        }
        System.out.println("Заметка успешно удалена");
    }

    public <T> void sortingAfterDelete(int a) {
        int middleNumNote_1 = 0;                                                     //Нужна чтобы запомнить номер заметки перед удалением и дельнейшем присвоении её следующей заметке
        int middleNumNote_2 = 0;                                                     //Нужна чтобы перед присвоением middleNumNot_1 новой заметке, запомнить номер новой заметки и присвоить его следующим заметкам
        int middleIndex = 0;                                                    //Флаг чтобы понимать были ли мы в массиве или нет

        if (a == 1) {
            middleNumNote_1 = quotes[index].getNumNote();
            quotes[index] = null;

            for (int i = index; i < quotes.length - 1; i++) {         //А здесь мы сортируем массив по новой и заполняем пустоту после удаления
                try {
                    if (quotes[i + 1] != null) {
                        quotes[i] = quotes[i + 1];
                        middleNumNote_2 = quotes[i + 1].getNumNote();                                                //Записываем во вторую переменную номер последующей заметки перед присваивание ей нового номера
                        quotes[i].setNumNote(middleNumNote_1);                                                    //Присваиваем последующей заметке номер той заметки, которую мы удалили
                        middleNumNote_1 = middleNumNote_2;
                        quotes[i + 1] = null;
                        middleIndex = 1;
                    }
                } catch (Exception ex_1) {
                    break;
                }
            }
        }
        if (a == 2 && middleIndex == 0) {                                                                 //Если мы не были в предыдущем цикле то необходимо переменной middleNumNote_1 присвоить номер удаляемого элемента
            middleNumNote_1 = news[index].getNumNote();
            news[index] = null;
            for (int i = index; i < news.length - 1; i++) {
                if (news[i + 1] != null) {
                    news[i] = news[i + 1];
                    middleNumNote_2 = news[i + 1].getNumNote();
                    news[i].setNumNote(middleNumNote_1);
                    middleNumNote_1 = middleNumNote_2;
                    news[i + 1] = null;
                }
                middleIndex = 1;
            }
        } else if (middleIndex == 1) {
            for (int i = 0; i < news.length - 1; i++) {
                if (news[i + 1] != null) {
                    middleNumNote_2 = news[i].getNumNote();
                    news[i].setNumNote(middleNumNote_1);
                    middleNumNote_1 = news[i + 1].getNumNote();
                }
                if (news[news.length - 1] != null) {
                    news[news.length - 1].setNumNote(middleNumNote_2);                                      //Т.к. на последнем цикле последнему элементу массива не получится присвоить новый номер, приходится делать это вне цикла
                }
            }
        }
        if (a == 3 && middleIndex == 0) {
            middleNumNote_1 = booklists[index].getNumNote();
            booklists[index] = null;
            for (int i = index; i < booklists.length - 1; i++) {
                if (booklists[i + 1] != null) {
                    booklists[i] = booklists[i + 1];
                    booklists[i].setNumNote(middleNumNote_1);
                    middleNumNote_1 = middleNumNote_2;
                    booklists[i + 1] = null;
                }
            }
        } else if (middleIndex == 1) {
            for (int i = 0; i < booklists.length - 1; i++) {
                if (booklists[i + 1] != null) {
                    middleNumNote_2 = booklists[i].getNumNote();
                    booklists[i].setNumNote(middleNumNote_1);
                    middleNumNote_1 = booklists[i + 1].getNumNote();
                }
                if (booklists[booklists.length - 1] != null) {
                    booklists[booklists.length - 1].setNumNote(middleNumNote_2);
                }
            }
        }
    }

    public void changeName() {
        System.out.print("Введите новое название заметки: ");
        if (middleQuote != null) {
            middleQuote.setTitle(console.nextLine());
        }
        if (middleNews != null) {
            middleNews.setTitle(console.nextLine());
        }
        if (middleBooklist != null) {
            middleBooklist.setTitle(console.nextLine());
        }
        System.out.println("Название успешно изменено");
    }

    public void changeBody() {
        System.out.print("Введите новое тело заметки: ");
        if (middleQuote != null) {
            middleQuote.setBody(console.nextLine());
        }
        if (middleNews != null) {
            middleNews.setBody(console.nextLine());
        }
        if (middleBooklist != null) {
            middleBooklist.setBody(console.nextLine());
        }
        System.out.println("Тело успешно изменено");
    }
}
