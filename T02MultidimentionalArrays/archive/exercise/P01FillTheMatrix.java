package T02MultidimentionalArrays.archive.exercise;

import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(",\\s+");
        int rows = Integer.parseInt(input[0]);
        String pattern = input[1];

        if (pattern.equals("A")) {
            printMatrix(getMatrixByPatternA(rows));
        } else {
            printMatrix(getMatrixByPatternB(rows));
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


    public static int[][] getMatrixByPatternB(int rows) {
        int[][] matrix = new int[rows][rows];
        int num = 1;
        for (int col = 0; col < rows; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < rows; row++) {
                    matrix[row][col] = num;
                    num++;
                }
            } else {
                for (int row = rows - 1; row >= 0; row--) {
                    matrix[row][col] = num;
                    num++;
                }
            }
        }
        return matrix;
    }

    public static int[][] getMatrixByPatternA(int rows) {
        int[][] matrix = new int[rows][rows];
        int num = 1;
        for (int col = 0; col < rows; col++) {
            for (int row = 0; row < rows; row++) {
                matrix[row][col] = num;
                num++;
            }
        }
        return matrix;
    }
}
