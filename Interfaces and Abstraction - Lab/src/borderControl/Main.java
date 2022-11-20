package borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Identifiable> identifiables = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] inputParts = input.split("\\s+");

            if (inputParts.length == 2) {
                String robotModel = inputParts[0];
                String robotId = inputParts[1];
                Robot robot = new Robot(robotModel, robotId);
                identifiables.add(robot);

            } else if (inputParts.length == 3){
                String personName = inputParts[0];
                int age = Integer.parseInt(inputParts[1]);
                String personId = inputParts[2];
                Citizen citizen = new Citizen(personName, age, personId);
                identifiables.add(citizen);
            }


            input = scanner.nextLine();
        }

        String fakeId = scanner.nextLine();
        for (Identifiable identifiable : identifiables) {
            if (identifiable.getId().endsWith(fakeId)){
                System.out.println(identifiable.getId());
            }
        }

    }
}
