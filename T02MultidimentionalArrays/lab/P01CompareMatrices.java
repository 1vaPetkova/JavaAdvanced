package T02MultidimentionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P01CompareMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] rowsAndCols = readArray(scan.nextLine());

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] firstMatrix = readNewMatrix(rows, cols, scan);

        rowsAndCols = readArray(scan.nextLine());

        rows = rowsAndCols[0];
        cols = rowsAndCols[1];

        int[][] secondMatrix = readNewMatrix(rows, cols, scan);

        if (matricesAreEqual(firstMatrix, secondMatrix)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static boolean matricesAreEqual(int[][] first, int[][] second) {
        if (first.length != second.length) {
            return false;
        }
        for (int row = 0; row < first.length; row++) {
            int[] firstArray = first[row];
            int[] secondArray = second[row];
            if (firstArray.length != secondArray.length) {
                return false;
            }
            for (int col = 0; col < firstArray.length; col++) {
                if (firstArray[col] != secondArray[col]) {
                    return false;
                }
            }
        }
        return true;
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
        return Arrays.stream(line.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
