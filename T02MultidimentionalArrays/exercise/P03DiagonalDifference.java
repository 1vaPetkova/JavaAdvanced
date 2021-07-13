package T02MultidimentionalArrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());

        int[][] matrix = readNewMatrix(rows, scan, "\\s+");
      //  printMatrix(matrix);
        int primarySum = getSumInPrimaryDiagonal(rows, matrix);
        int secondarySum = getSumInSecondaryDiagonal(rows, matrix);
        System.out.println(Math.abs(primarySum - secondarySum));
    }

    private static int getSumInSecondaryDiagonal(int rows, int[][] matrix) {
        int sumSecondary = 0;
        for (int row = 0; row < rows; row++) {
            sumSecondary += matrix[matrix.length - 1 - row][row];
        }
        return sumSecondary;
    }

    private static int getSumInPrimaryDiagonal(int rows, int[][] matrix) {
        int sumPrimary = 0;
        for (int row = 0; row < rows; row++) {
            sumPrimary += matrix[row][row];
        }
        return sumPrimary;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int[][] readNewMatrix(int rows, Scanner scan, String pattern) {
        int[][] matrix = new int[rows][rows];
        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scan.nextLine(), pattern);
        }
        return matrix;
    }

    public static int[] readArray(String line, String pattern) {
        return Arrays.stream(line.split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
