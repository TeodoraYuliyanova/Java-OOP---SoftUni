package FoodShortage;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Buyer> buyers = new HashMap<>();

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfPeople; i++) {
            String[] peopleParts = scanner.nextLine().split("\\s+");
            String name = peopleParts[0];
            int age = Integer.parseInt(peopleParts[1]);
            Buyer buyer;

            if (peopleParts.length == 3) {
                //Rebel
                String group = peopleParts[2];
                buyer = new Rebel(name,age,group);

            } else {
                //Citizen
                String id = peopleParts[2];
                String birthDate = peopleParts[3];

                buyer = new Citizen(name,age,id,birthDate);

            }

            buyers.put(name, buyer);
        }


        String personName = scanner.nextLine();

        while (!personName.endsWith("End")) {
            Buyer buyer = buyers.get(personName);

            if (buyer != null) {
                buyer.buyFood();
            }


            personName = scanner.nextLine();
        }

        int totalFood = buyers.values().stream().mapToInt(Buyer::getFood).sum();

        System.out.println(totalFood);


    }
}
