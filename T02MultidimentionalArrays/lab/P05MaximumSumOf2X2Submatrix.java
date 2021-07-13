package T02MultidimentionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P05MaximumSumOf2X2Submatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] rowsAndCols = readArray(scan.nextLine(), ",\\s+");

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = readNewMatrix(rows, cols, scan, ",\\s+");

        int[][] maxSubMatrix = getMaxSubMatrix2By2(matrix);
       printMatrix(maxSubMatrix);
        System.out.println(getElementsSumWithStream(maxSubMatrix));

    }

    private static int getElementsSumWithStream(int[][] matrix) {
        return Arrays.stream(matrix).flatMapToInt(Arrays::stream).sum();
    }

    public static int[][] getMaxSubMatrix2By2(int[][] matrix) {
        int maxSum = 0;
        int bestRow = 0;
        int bestCol = 0;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum = matrix[row][col] +
                        matrix[row][col + 1] +
                        matrix[row + 1][col] +
                        matrix[row + 1][col + 1];
                if (sum > maxSum) {
                    maxSum = sum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }
        return new int[][]{
                {matrix[bestRow][bestCol], matrix[bestRow][bestCol + 1]},
                {matrix[bestRow + 1][bestCol], matrix[bestRow + 1][bestCol + 1]}
        };
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