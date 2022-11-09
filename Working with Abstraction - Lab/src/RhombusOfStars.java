import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        printTopPart(size);

        printBottomPart(size);

    }

    private static void printBottomPart(int size) {
        for (int starsCount = size - 1; starsCount > 0 ; starsCount--) {

            printRow(size, starsCount);
        }
    }

    private static void printTopPart(int size) {
        for (int starsCount = 1; starsCount <= size; starsCount++) {

            printRow(size, starsCount);
        }
    }

    private static void printRow(int size, int starsCount) {
        for (int i = 0; i < size - starsCount; i++) {
            System.out.print(" ");
        }

        for (int i = 0; i < starsCount - 1; i++) {
            System.out.print("* ");
        }

        System.out.println("*");
    }
}
