package T02MultidimentionalArrays.archive.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P04MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] rowsAndCols = readArray(scan.nextLine());

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];
        int[][] matrix = readNewMatrix(rows, cols, scan);

        printMatrix(getMaxSubMatrix2By2(matrix));
        System.out.println(getElementsSumWithStream(getMaxSubMatrix2By2(matrix)));
    }

    private static int getElementsSumWithStream(int[][] matrix) {
        return Arrays.stream(matrix).flatMapToInt(Arrays::stream).sum();
    }

    private static int[][] getMaxSubMatrix2By2(int[][] matrix) {
        int sum = 0;
        int maxSum = 0;
        int bestRow = 0;
        int bestCol = 0;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                sum = matrix[row][col] + matrix[row][col + 1] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1];
                if (sum > maxSum) {
                    maxSum = sum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }
        int[][] subMatrix = new int[2][2];
        for (int bestR = 0; bestR < 2; bestR++) {
            for (int bestC = 0; bestC < 2; bestC++) {
                subMatrix[bestR][bestC] = matrix[bestRow + bestR][bestCol + bestC];
            }
        }
        return subMatrix;
    }


    private static int[][] readNewMatrix(int rows, int cols, Scanner scan) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scan.nextLine());
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static int[] readArray(String line) {
        return Arrays.stream(line.split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
