import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class EnterNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = new ArrayList<>();


        int start = 1;
        while (numbersList.size() < 10) {
            int number;

            try {
                number = readNumber(start, 100, scanner);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                continue;
            }

            numbersList.add(number);
            start = number;
        }

        System.out.println(numbersList.stream().map(String::valueOf).collect(Collectors.joining(", ")));

    }


    private static int readNumber(int start, int end, Scanner scanner) {

        int number;
        try {
            number = Integer.parseInt(scanner.nextLine());
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("Invalid Number!");
        }

        if (number <= start || number >= end) {
            throw new IllegalArgumentException("Your number is not in range " + start + " - 100!");
        }
        return number;
    }
}

