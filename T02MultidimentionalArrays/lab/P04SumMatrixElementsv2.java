package T02MultidimentionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P04SumMatrixElementsv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] rowsAndCols = readArray(scan.nextLine());

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] tokens = scan.nextLine().split(",\\s+");
            for (int col = 0; col < tokens.length; col++) {
                matrix[row][col] = Integer.parseInt(tokens[col]);
            }
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(getElementsSum(matrix));
    }

    private static int getElementsSum(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }
        }
        return sum;
    }

    public static int[] readArray(String line) {
        return Arrays.stream(line.split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
