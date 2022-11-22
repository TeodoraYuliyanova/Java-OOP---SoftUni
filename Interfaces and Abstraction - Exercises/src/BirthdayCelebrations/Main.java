package BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Birthable> birthableCreatures = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {

            String[] inputParts = input.split("\\s+");
            String creatureType = inputParts[0];

            switch (creatureType) {

                case "Citizen":
                    String name = inputParts[1];
                    int age = Integer.parseInt(inputParts[2]);
                    String id = inputParts[3];
                    String birthDate = inputParts[4];
                    Citizen citizen = new Citizen(name, age, id, birthDate);
                    birthableCreatures.add(citizen);

                    break;

                case "Pet":
                    String petName = inputParts[1];
                    String petBirthday = inputParts[2];
                    Pet pet = new Pet(petName, petBirthday);
                    birthableCreatures.add(pet);

                    break;

                case "Robot":
                    String robotId = inputParts[1];
                    String model = inputParts[2];
                    Robot robot = new Robot(robotId, model);

                    break;


            }


            input = scanner.nextLine();
        }

        String yearToCheck = scanner.nextLine();

        for (Birthable birthableCreature : birthableCreatures) {
            if (birthableCreature.getBirthDate().endsWith(yearToCheck)) {
                System.out.println(birthableCreature.getBirthDate());
            }
        }
    }
}
