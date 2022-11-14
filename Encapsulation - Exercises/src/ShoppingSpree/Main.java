package ShoppingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new HashMap<>();

        String[] peopleInfo = scanner.nextLine().split(";");
        for (String personInfo : peopleInfo) {
            String[] personParts = personInfo.split("=");
            String name = personParts[0];
            double money = Double.parseDouble(personParts[1]);

            try {
                Person person = new Person(name, money);
                people.put(name, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String[] productsInfo = scanner.nextLine().split(";");
        for (String productInfo : productsInfo) {
            String[] productParts = productInfo.split("=");
            String name = productParts[0];
            double cost = Double.parseDouble(productParts[1]);

            try {
                Product product = new Product(name, cost);
                products.put(name, product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String command = scanner.nextLine();
        while (!"END".equals(command)) {

            String[] commandParts = command.split("\\s+");
            String name = commandParts[0];
            String product = commandParts[1];

            Person buyer = people.get(name);
            Product productToBuy = products.get(product);

            try {
                buyer.buyProduct(productToBuy);
                System.out.printf("%s bought %s%n", name, product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }


            command = scanner.nextLine();
        }

        people.values().forEach(System.out::println);

    }
}
