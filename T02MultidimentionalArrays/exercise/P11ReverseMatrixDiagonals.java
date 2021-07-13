package T02MultidimentionalArrays.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P11ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = scan.nextInt();
        int cols = scan.nextInt();
        scan.nextLine();

        int[][] matrix = readNewMatrix(rows, cols, scan, "\\s+");
        //  printMatrix(matrix);
        int row = rows - 1;
        int col = cols - 1;
        while (row >= 0) {
            int r = row;
            int c = col;
            while (c < cols && r >= 0) {
                System.out.print(matrix[r--][c++] + " ");
            }
            System.out.println();
            col--;
            if (col == -1) {
                col = 0;
                row--;
            }
        }


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
