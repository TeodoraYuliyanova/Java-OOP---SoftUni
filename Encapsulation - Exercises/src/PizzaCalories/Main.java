package PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaInfo = scanner.nextLine().split("\\s+");
        String pizzaName = pizzaInfo[1];
        int numberToppings = Integer.parseInt(pizzaInfo[2]);

        String[] doughInfo = scanner.nextLine().split("\\s+");
        String flourType = doughInfo[1];
        String bakingTechnique = doughInfo[2];
        int doughWeight = Integer.parseInt(doughInfo[3]);


        try {
            Pizza pizza = new Pizza(pizzaName, numberToppings);
            Dough dough = new Dough(flourType, bakingTechnique, doughWeight);
            pizza.setDough(dough);

            String toppingLines = scanner.nextLine();
            while (!toppingLines.equals("END")) {

                String[] toppingInfo = toppingLines.split("\\s+");

                String toppingType = toppingInfo[1];
                int toppingWeight = Integer.parseInt(toppingInfo[2]);
                Topping topping = new Topping(toppingType, toppingWeight);

                pizza.addTopping(topping);


                toppingLines = scanner.nextLine();
            }

            System.out.printf("%s - %.2f", pizzaName, pizza.getOverallCalories());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }
}
