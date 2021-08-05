package T02MultidimentionalArrays.archive.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());

        int[][] matrix = readNewMatrix(rows, rows, scan, "\\s+");

        System.out.println(Math.abs(getPrimaryDiagonalSum(matrix) - getSecondaryDiagonalSum(matrix)));
    }

    private static int getSecondaryDiagonalSum(int[][] matrix) {
        int secondarySum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (col == matrix[row].length - row-1) {
                    secondarySum += matrix[row][col];
                }
            }
        }
        return secondarySum;
    }


    private static int getPrimaryDiagonalSum(int[][] matrix) {
        int primarySum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == col) {
                    primarySum += matrix[row][col];
                }
            }
        }
        return primarySum;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int[][] readNewMatrix(int rows, int cols, Scanner scan, String pattern) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split(pattern))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            ;
        }
        return matrix;
    }


}
