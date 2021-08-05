package T02MultidimentionalArrays.archive.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        String[] rowsAndCols = line.split("\\s+");
        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);

        String[][] matrix = readNewMatrix(rows, cols, scan);
        String input = "";
        while (!(input = scan.nextLine()).equals("END")) {
            String[] tokens = input.split("\\s+");
            if (!input.startsWith("swap") || tokens.length != 5) {
                System.out.println("Invalid input!");
                continue;
            }
            int fRow = Integer.parseInt(tokens[1]);
            int fCol = Integer.parseInt(tokens[2]);
            int sRow = Integer.parseInt(tokens[3]);
            int sCol = Integer.parseInt(tokens[4]);
            if (!areCoordinatesValid(fRow, fCol, sRow, sCol, rows, cols)) {
                System.out.println("Invalid input!");
            } else {
                String tmp = matrix[fRow][fCol];
                matrix[fRow][fCol] = matrix[sRow][sCol];
                matrix[sRow][sCol] = tmp;
                printMatrix(matrix);
            }
        }

    }

    private static boolean areCoordinatesValid(int fRow, int fCol, int sRow, int sCol, int rows, int cols) {
        return fRow >= 0 && fRow < rows
                && sRow >= 0 && sRow < rows
                && fCol >= 0 && fCol < cols
                && sCol >= 0 && sCol < cols;

    }

    private static void printMatrix(String[][] matrix) {
        for (String[] arr : matrix) {
            for (String element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static String[][] readNewMatrix(int rows, int cols, Scanner scan) {
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scan.nextLine().split("\\s+");
        }
        return matrix;
    }

    public static String[] readArray(String line, String pattern) {
        return line.split(pattern);
    }
}
