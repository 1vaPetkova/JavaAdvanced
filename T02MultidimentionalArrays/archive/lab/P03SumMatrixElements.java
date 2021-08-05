package T02MultidimentionalArrays.archive.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P03SumMatrixElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] rowsAndCols = readArray(scan.nextLine());

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];
        int[][] matrix = readNewMatrix(rows, cols, scan);

        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(getElementsSumWithStream(matrix));
    }
    private static int getElementsSumWithStream(int[][] matrix) {
        return Arrays.stream(matrix).flatMapToInt(Arrays::stream).sum();
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
