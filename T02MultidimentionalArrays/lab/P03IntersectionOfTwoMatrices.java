package T02MultidimentionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());

        char[][] first = readNewMatrix(rows, cols, scan);
        char[][] second = readNewMatrix(rows, cols, scan);
        char[][] result = getMatricesIntersection(first, second);
        printMatrix(result);
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static char[][] getMatricesIntersection(char[][] first, char[][] second) {
        char[][] output = new char[first.length][];
        for (int row = 0; row < first.length; row++) {
            output[row] = new char[first[row].length];
            for (int col = 0; col < first[row].length; col++) {
                output[row][col] = first[row][col] == second[row][col]
                        ? first[row][col] : '*';
            }
        }


        return output;
    }

    private static char[][] readNewMatrix(int rows, int cols, Scanner scan) {
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] tokens = scan.nextLine().split("\\s+");
            for (int col = 0; col < tokens.length; col++) {
                matrix[row][col] = tokens[col].charAt(0);
            }
        }
        return matrix;
    }


}
