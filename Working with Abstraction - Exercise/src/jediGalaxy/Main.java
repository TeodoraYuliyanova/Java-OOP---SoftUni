package jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] galaxySize = readArr(scanner.nextLine());
        int rows = galaxySize[0];
        int cols = galaxySize[1];

        int[][] galaxy = new int[rows][cols];

        fillGalaxy(rows, cols, galaxy);

        String command = scanner.nextLine();
        long collectedStars = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] jediPosition = readArr(command);
            int[] evilPosition = readArr(scanner.nextLine());
            int evilRow = evilPosition[0];
            int evilCol = evilPosition[1];

            while (evilRow >= 0 && evilCol >= 0) {
                if (evilRow < galaxy.length && evilCol < galaxy[0].length) {
                    galaxy[evilRow][evilCol] = 0;
                }
                evilRow--;
                evilCol--;
            }

            int jediRow = jediPosition[0];
            int jediCol = jediPosition[1];

            while (jediRow >= 0 && jediCol < galaxy[1].length) {
                if (jediRow < galaxy.length && jediCol >= 0 && jediCol < galaxy[0].length) {
                    collectedStars += galaxy[jediRow][jediCol];
                }

                jediCol++;
                jediRow--;
            }

            command = scanner.nextLine();
        }

        System.out.println(collectedStars);


    }

    private static void fillGalaxy(int rows, int cols, int[][] galaxy) {
        int value = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                galaxy[row][col] = value++;
            }
        }
    }

    private static int[] readArr(String s) {
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
