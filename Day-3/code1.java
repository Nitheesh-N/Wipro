import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
               String username = sc.nextLine();
        int userage = sc.nextInt();
        Person p = new Person(username,userage);
        p.display();
    }
    static class Person {
        String name;
        int age;
        public Person(String name,int age) {
            this.name = name;
            this.age = age;
        }
        void display() {
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
        }
    }
}