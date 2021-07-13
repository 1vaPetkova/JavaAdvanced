package T02MultidimentionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class P04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] rowsAndCols = readArray(scan.nextLine(), ",\\s+");

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = readNewMatrix(rows, cols, scan, ",\\s+");

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(getElementsSum(matrix));
    }

    private static int getElementsSum(int[][] matrix) {
        int sum = 0;
        for (int[] array : matrix) {
            for (int element : array) {
                sum += element;
            }
        }
        return sum;
    }

    //sum of elements in 2d matrix with stream!!!!
    private static int getElementsSumWithStream(int[][] matrix) {
        return Arrays.stream(matrix).flatMapToInt(Arrays::stream).sum();
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
