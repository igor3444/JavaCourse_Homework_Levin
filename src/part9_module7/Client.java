package part9_module7;

public class Client extends Person implements Printable {


    String hairColor;

    public Client(String name, String gender, int age, String hairColor) {
        super(name, gender, age);
        this.hairColor = hairColor;
    }


    void greetingClient() {
        System.out.println("- Добро пожаловать: " + name);
    }

    void infoForTheEmployee() {
        System.out.println("- Клиента зовут: " + name);
        System.out.println("- Цвет волос: " + hairColor);
    }


    @Override
    public void showName() {
        System.out.println("*" + name);
    }

    @Override
    public void showAge() {
        System.out.println("*" + age);
    }

    @Override
    public void showGender() {
        System.out.println("*" + gender);
    }

    public String toString() {
        return "Клиент: " + name;
    }
}

