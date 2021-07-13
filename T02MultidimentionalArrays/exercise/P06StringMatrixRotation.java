package T02MultidimentionalArrays.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rotationDegrees = getRotationDegrees(scan);
        String input = "";
        int cols = 0;
        List<String> words = new ArrayList<>();
        while (!(input = scan.nextLine()).equals("END")) {
            words.add(input);
            if (input.length() > cols) {
                cols = input.length();
            }
        }
        int rows = words.size();
        char[][] matrix = getBaseMatrix(rows, cols, words);

        switch (rotationDegrees) {
            case 90:
                char[][] result90 = rotateMatrix90degrees(rows, cols, matrix);
                printMatrix(result90);
                break;
            case 180:
                char[][] result180 = rotateMatrix180degrees(rows, cols, matrix);
                printMatrix(result180);
                break;
            case 270:
                char[][] result270 = rotateMatrix270degrees(rows, cols, matrix);
                printMatrix(result270);
                break;
            case 0:
                printMatrix(matrix);
                break;

        }

    }

    private static char[][] rotateMatrix270degrees(int rows, int cols, char[][] matrix) {
        char[][] result = new char[cols][rows];
        for (int row = 0; row < cols; row++) {
            for (int col = 0; col < rows; col++) {
                result[row][col] = matrix[col][cols-1-row];
            }
        }
        return result;
    }

    private static char[][] rotateMatrix180degrees(int rows, int cols, char[][] matrix) {
        char[][] result = new char[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                result[row][col] = matrix[matrix.length - 1 - row][matrix[row].length - 1 - col];
            }
        }
        return result;
    }


    private static char[][] rotateMatrix90degrees(int rows, int cols, char[][] matrix) {
        char[][] result = new char[cols][rows];
        for (int row = 0; row < cols; row++) {
            for (int col = 0; col < rows; col++) {
                result[row][col] = matrix[rows - 1 - col][row];
            }
        }
        return result;
    }

    private static int getRotationDegrees(Scanner scan) {
        String command = scan.nextLine();
        int fIndex = command.indexOf('(');
        int sIndex = command.indexOf(')');
        return Integer.parseInt(command.substring(fIndex + 1, sIndex)) % 360;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char element : arr) {
                System.out.print(element);
            }
            System.out.println();
        }
    }

    private static char[][] getBaseMatrix(int rows, int cols, List<String> words) {
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (words.get(row).length() > col) {
                    matrix[row][col] = words.get(row).charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }
        return matrix;
    }

    public static String[] readArray(String line, String pattern) {
        return line.split(pattern);
    }
}
