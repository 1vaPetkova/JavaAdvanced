package T02MultidimentionalArrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        int cols = scan.nextInt();
        scan.nextLine();

        String[][] matrix = readNewMatrix(rows, cols, scan, "\\s+");

        String input = "";
        while (!(input = scan.nextLine()).equals("END")) {
            if (!isValid(input, matrix)) {
                System.out.println("Invalid input!");
            } else {
                int fRow = Integer.parseInt(input.split("\\s+")[1]);
                int fCol = Integer.parseInt(input.split("\\s+")[2]);
                int sRow = Integer.parseInt(input.split("\\s+")[3]);
                int sCol = Integer.parseInt(input.split("\\s+")[4]);
                swapElementsInMatrix(fRow, fCol, sRow, sCol, matrix);
                printMatrix(matrix);
            }
        }
    }

    private static boolean isValid(String input, String[][] matrix) {
        String[] tokens = input.split("\\s+");
        if (!tokens[0].equals("swap")) {
            return false;
        }
        if (tokens.length != 5) {
            return false;
        }
        int fRow = Integer.parseInt(tokens[1]);
        int fCol = Integer.parseInt(tokens[2]);
        int sRow = Integer.parseInt(tokens[3]);
        int sCol = Integer.parseInt(tokens[4]);
        if (!isInBounds(fRow, fCol, matrix) | !isInBounds(sRow, sCol, matrix)) {
            return false;
        }
        return true;
    }

    private static boolean isInBounds(int row, int col, String[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static void swapElementsInMatrix(int fRow, int fCol, int sRow, int sCol, String[][] matrix) {
        String tempElement = matrix[sRow][sCol];
        matrix[sRow][sCol] = matrix[fRow][fCol];
        matrix[fRow][fCol] = tempElement;
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] arr : matrix) {
            for (String element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static String[][] readNewMatrix(int rows, int cols, Scanner scan, String pattern) {
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scan.nextLine().split(pattern);
        }
        return matrix;
    }

}