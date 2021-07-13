package T02MultidimentionalArrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P04MaximalSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] rowsAndCols = readArray(scan.nextLine(), "\\s+");
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = readNewMatrix(rows, cols, scan, "\\s+");
        int[][] subMatrix = getMaxSubMatrix3By3(matrix);
        System.out.println("Sum = " + getSumOfSubMatrixElements(subMatrix));
        printMatrix(subMatrix);

    }

    private static int getSumOfSubMatrixElements(int[][] subMatrix) {
        return Arrays.stream(subMatrix).flatMapToInt(Arrays::stream).sum();
    }

    private static int[][] getMaxSubMatrix3By3(int[][] matrix) {
        int sum = 0;
        int maxSum = 0;
        int bestRow = 0;
        int bestCol = 0;
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
                        matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
                if (sum > maxSum) {
                    maxSum = sum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }
        int[][] subMatrix = new int[3][3];
        for (int bestR = 0; bestR < 3; bestR++) {
            for (int bestC = 0; bestC < 3; bestC++) {
                subMatrix[bestR][bestC] = matrix[bestRow + bestR][bestCol + bestC];
            }
        }
        return subMatrix;
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
