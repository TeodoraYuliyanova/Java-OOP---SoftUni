import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        try {
            int number = Integer.parseInt(input);
            double result = Math.sqrt(number);
            System.out.printf("%.2f%n" , result);
        }catch (IllegalArgumentException e){
            System.out.println("Invalid");
        }finally {
            System.out.println("Goodbye");
        }

    }
}
