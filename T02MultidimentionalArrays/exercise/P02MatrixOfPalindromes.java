package T02MultidimentionalArrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] rowsAndCols = readArray(scan.nextLine());

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        String[][] matrix = getPalindromeMatrix(rows, cols);
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] arr : matrix) {
            for (String element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static String[][] getPalindromeMatrix(int rows, int cols) {
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char[] chars = element(row, col);
                matrix[row][col] = palindrome(chars);
            }
        }
        return matrix;
    }


    public static String palindrome(char[] chars) {
        StringBuilder palindrome = new StringBuilder();
        for (char ch : chars) {
            palindrome.append(ch);
        }
        return palindrome.toString();
    }

    public static char[] element(int row, int col) {
        char[] chars = new char[3];
        chars[0] = (char) ('a' + row);
        chars[chars.length - 1] = chars[0];
        chars[1] = (char) ('a' + row + col);
        return chars;
    }


    public static int[] readArray(String line) {
        return Arrays.stream(line.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
