package PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coordinatesRectangle = readLine(scanner);

        int bottomLeftX = coordinatesRectangle[0];
        int bottomLeftY = coordinatesRectangle[1];
        Point bottomLeft = new Point(bottomLeftX, bottomLeftY);

        int topRightX = coordinatesRectangle[2];
        int topRightY = coordinatesRectangle[3];
        Point topRight = new Point(topRightX, topRightY);

        Rectangle rectangle = new Rectangle(bottomLeft, topRight);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {

            int[] coordinates = readLine(scanner);

            Point current = new Point(coordinates[0], coordinates[1]);
            System.out.println(rectangle.contains(current));

        }

    }

    private static int[] readLine(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
