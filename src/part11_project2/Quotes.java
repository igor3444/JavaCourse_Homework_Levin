package part11_project2;
import java.util.Scanner;

public class Quotes extends Note implements ActionWithNotes {

    public String author;
    Scanner console = new Scanner(System.in);

    public Quotes() {
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String toString() {
        return "№ " + getNumNote() + "\n- Заголовок: " + getTitle() + "\n- Тело: " + getBody() + "\n- Автор: " + author;
    }

    @Override
    public void creatingNote() {
        System.out.print("Введите заголовок цитаты: ");
        setTitle(console.nextLine());
        System.out.print("Введите тело цитаты: ");
        setBody(console.nextLine());
        System.out.print("Введите автора цитаты: ");
        setAuthor(console.nextLine());
    }

    @Override
    public boolean noteSearch(String title) {
        return getTitle().contains(title);
    }
}
