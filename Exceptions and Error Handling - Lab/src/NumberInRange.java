import java.util.Arrays;
import java.util.Scanner;

public class NumberInRange {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int firstNum = numbers[0];
        int secondNum = numbers[1];


        System.out.printf("Range: [%d...%d]%n", firstNum, secondNum);

        int number = returnNumberInRange(scanner, firstNum,secondNum);

        System.out.printf("Valid number: %d", number);

    }

    public static int returnNumberInRange(Scanner scanner, int start, int end) {

        while (true) {
            String line = scanner.nextLine();
            try {
                int numberToCheck = Integer.parseInt(line);
                if (numberToCheck >= start && numberToCheck <= end) {
                    return numberToCheck;
                }
            }catch (Exception e){
            }
            System.out.println("Invalid number: " + line);
        }
    }
}