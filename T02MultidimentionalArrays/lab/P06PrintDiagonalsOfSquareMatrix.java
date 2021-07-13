package T02MultidimentionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int[][] matrix = readNewMatrix(rows, scan, "\\s+");

        printPrimaryDiagonal(matrix);
        printSecondaryDiagonal(matrix);
    }

    private static void printSecondaryDiagonal(int[][] matrix) {
        for (int el = 0; el < matrix.length; el++) {
            System.out.print(matrix[matrix.length - 1 - el][el] + " ");
        }
    }

    private static void printPrimaryDiagonal(int[][] matrix) {
        for (int el = 0; el < matrix.length; el++) {
            System.out.print(matrix[el][el] + " ");
        }
        System.out.println();
    }

    private static int[][] readNewMatrix(int rows, Scanner scan, String pattern) {
        int[][] matrix = new int[rows][rows];
        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scan.nextLine(), pattern);
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

    public static int[] readArray(String line, String pattern) {
        return Arrays.stream(line.split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
