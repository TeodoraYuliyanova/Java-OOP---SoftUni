package SortByNameAndAge;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < numberOfPeople; i++) {
            String[] personInfo = scanner.nextLine().split(" ");
            String firstName = personInfo[0];
            String lastName = personInfo[1];
            int age = Integer.parseInt(personInfo[2]);
            Person person = new Person(firstName,lastName,age);

            people.add(person);
        }

        people.sort((firstPerson, secondPerson) -> {
            int compare = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());

            if (compare != 0) {
                return compare;
            } else {
                return Integer.compare(firstPerson.getAge(), secondPerson.getAge());
            }
        });

        for (Person person : people) {
            System.out.println(person.toString());
        }
    }


}
