package ValidationData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberPeople = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < numberPeople; i++) {

            try {
                String[] personInfo = scanner.nextLine().split("\\s+");
                String firstName = personInfo[0];
                String lastName = personInfo[1];
                int age = Integer.parseInt(personInfo[2]);
                double salary = Double.parseDouble(personInfo[3]);
                Person person = new Person(firstName, lastName, age, salary);
                people.add(person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        double percentage = Double.parseDouble(scanner.nextLine());

        for (Person person : people) {
            person.increaseSalary(percentage);
            System.out.println(person.toString());
        }
    }
}
