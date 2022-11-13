package FirstAndReserveTeam;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPlayers = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < numberOfPlayers; i++) {

            String[] playerInfo = scanner.nextLine().split(" ");
            String firstName = playerInfo[0];
            String lastName = playerInfo[1];
            int age = Integer.parseInt(playerInfo[2]);
            double salary = Double.parseDouble(playerInfo[3]);

            try {
                Person person = new Person(firstName, lastName, age, salary);
                people.add(person);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        Team team = new Team("Black Eagle");
        for (Person person : people) {
            team.addPlayer(person);
        }


        System.out.printf("First team have %d players%n" , team.getFirstTeam().size());
        System.out.printf("Reserve team have %d players" , team.getReserveTeam().size());
    }
}
