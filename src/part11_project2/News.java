package part11_project2;
import java.util.Scanner;

public class News extends Note implements ActionWithNotes {

    public String date;
    public String country;

    Scanner console = new Scanner(System.in);

    public News() {
    }

    public String gateDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }


    public String toString() {
        return "№ " + getNumNote() + "\n- Заголовок: " + getTitle() + "\n- Тело: " + getBody() + "\n- Дата: " + date + "\n- Страна: " + country;
    }

    @Override
    public void creatingNote() {
        System.out.print("Введите заголовок новости: ");
        setTitle(console.nextLine());
        System.out.print("Введите тело новости: ");
        setBody(console.nextLine());
        System.out.print("Введите дату новости: ");
        setDate(console.nextLine());
        System.out.print("Введите страну происхождения новости: ");
        setCountry(console.nextLine());
    }

    @Override
    public boolean noteSearch(String title) {
        return getTitle().contains(title);
    }
}
