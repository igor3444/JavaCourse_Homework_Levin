package part11_project2;
import java.util.Scanner;

public class Booklist extends Note implements ActionWithNotes {

    public String year;
    public String author;

    Scanner console = new Scanner(System.in);

    public Booklist() {
    }

    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String toString() {
        return "№ " + getNumNote() + "\n- Заголовок: " + getTitle() + "\n- Тело: " + getBody() + "\n- Год: " + year + "\n- Автор: " + author;
    }

    @Override
    public void creatingNote() {
        System.out.print("Введите заголовок книги: ");
        setTitle(console.nextLine());
        System.out.print("Введите описание книги: ");
        setBody(console.nextLine());
        System.out.print("Введите год книги: ");
        setYear(console.nextLine());
        System.out.print("Введите автора книги: ");
        setAuthor(console.nextLine());
    }

    @Override
    public boolean noteSearch(String title) {
        return getTitle().contains(title);
    }
}
