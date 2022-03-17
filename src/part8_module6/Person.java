package part8_module6;

public abstract class Person {

        String name;
        String gender;
        int age;

        public Person(String name, String gender, int age) {
            this.name = name;
            this.gender = gender;
            this.age = age;
        }


        public void specifications() {
            System.out.println("Пол: " + gender);
            System.out.println("Возраст: " + age);
            System.out.println("Имя: " + name);
        }
}
