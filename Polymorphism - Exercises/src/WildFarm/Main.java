package WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        String line = scanner.nextLine();
        while (!line.equals("End")) {

            Animal animal = createAnimal(line);
            animals.add(animal);

            Food food = createFood(scanner);

            animal.makeSound();

            try {
                animal.eat(food);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            line = scanner.nextLine();
        }

        animals.forEach(System.out::println);

    }

    private static Food createFood(Scanner scanner) {
        String[] foodTokens = scanner.nextLine().split("\\s+");
        String foodType = foodTokens[0];
        Integer quantity = Integer.parseInt(foodTokens[1]);

        if (foodType.equals("Meat")) {
            return new Meat(quantity);
        } else if (foodType.equals("Vegetable")) {
            return new Vegetable(quantity);
        } else {
            throw new IllegalArgumentException("Can not create that food");
        }
    }

    public static Animal createAnimal(String line) {

        String[] animalTokens = line.split("\\s+");
        String animalType = animalTokens[0];
        String animalName = animalTokens[1];
        Double animalWeight = Double.parseDouble(animalTokens[2]);
        String livingRegion = animalTokens[3];

        switch (animalType) {

            case "Cat":
                String catBreed = animalTokens[4];
                return new Cat(animalType, animalName, animalWeight, livingRegion, catBreed);

            case "Mouse":
                return new Mouse(animalType, animalName, animalWeight, livingRegion);

            case "Tiger":
                return new Tiger(animalType, animalName, animalWeight, livingRegion);

            case "Zebra":
                return new Zebra(animalType, animalName, animalWeight, livingRegion);

            default:
                throw new IllegalArgumentException("Such animal does not exist");
        }

    }
}
