package T02MultidimentionalArrays.exercise;

import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int rows = Integer.parseInt(input.split(", ")[0]);
        String pattern = input.split(", ")[1];

        int[][] matrix = new int[rows][rows];
        if (pattern.equals("A")) {
            matrix = fillMatrixByPatternA(rows);
        } else if (pattern.equals("B")) {
            matrix = fillMatrixByPatternB(rows);
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int[][] fillMatrixByPatternB(int rows) {
        int[][] matrixB = new int[rows][rows];
        int currentElement = 1;
        for (int col = 0; col < matrixB[rows - 1].length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrixB.length; row++) {
                    matrixB[row][col] = currentElement++;
                }
            } else {
                for (int row = matrixB.length - 1; row >= 0; row--) {
                    matrixB[row][col] = currentElement++;
                }
            }
        }
        return matrixB;
    }

    private static int[][] fillMatrixByPatternA(int rows) {
        int[][] matrixA = new int[rows][rows];
        int currentElement = 1;
        for (int col = 0; col < matrixA[rows - 1].length; col++) {
            for (int row = 0; row < matrixA.length; row++) {
                matrixA[row][col] = currentElement++;
            }
        }
        return matrixA;
    }
}
