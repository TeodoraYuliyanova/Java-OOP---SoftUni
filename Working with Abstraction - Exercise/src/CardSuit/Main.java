package CardSuit;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();


        System.out.println(line + ":");
        Arrays.stream(Cards.values()).forEach(e -> System.out.printf("Ordinal value: %d; Name value: %s%n" , e.ordinal(), e.name()));
    }
}
