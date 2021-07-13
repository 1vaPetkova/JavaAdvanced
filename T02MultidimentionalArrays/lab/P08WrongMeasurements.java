package T02MultidimentionalArrays.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());
        int[][] matrix = readNewMatrix(rows, 0, scan, "\\s+");

        int[] coordinates = readArray(scan.nextLine(), "\\s+");
        int wrongValue = matrix[coordinates[0]][coordinates[1]];

        List<int[]> updatedValues = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongValue) {
                    updatedValues.add(new int[]{row, col, getClosestItemsSum(row, col, matrix, wrongValue)});
                }
            }
        }
        for (int[] updatedValue : updatedValues) {
            matrix[updatedValue[0]][updatedValue[1]] = updatedValue[2];
        }
        printMatrix(matrix);
    }

    public static boolean isInBounds(int row, int col, int[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
//    public static boolean isOutOfBounds(int row, int col, int[][] matrix) {
//        return !isInBounds(row,col,matrix);
//    }

    private static int getClosestItemsSum(int row, int col, int[][] matrix, int wrongValue) {
        int sum = 0;
        if (isInBounds(row, col + 1, matrix) && matrix[row][col + 1] != wrongValue) {
            sum += matrix[row][col + 1];
        }
        if (isInBounds(row, col - 1, matrix) && matrix[row][col - 1] != wrongValue) {
            sum += matrix[row][col - 1];
        }
        if (isInBounds(row + 1, col, matrix) && matrix[row + 1][col] != wrongValue) {
            sum += matrix[row + 1][col];
        }
        if (isInBounds(row - 1, col, matrix) && matrix[row - 1][col] != wrongValue) {
            sum += matrix[row - 1][col];
        }
        return sum;
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

