package T02MultidimentionalArrays.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P02PositionOf {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] rowsAndCols = readArray(scan.nextLine());

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = readNewMatrix(rows, cols, scan);

        int number = Integer.parseInt(scan.nextLine());

        List<int[]> output = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int current = matrix[row][col];
                if (current == number) {
                    output.add(new int[]{row, col});
                }
            }
        }
        if (output.isEmpty()) {
            System.out.println("not found");
        } else {
            for (int[] indices : output) {
                System.out.println(indices[0] + " " + indices[1]);
            }
        }
    }

    private static int[][] readNewMatrix(int rows, int cols, Scanner scan) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scan.nextLine());
        }
        return matrix;
    }

    public static int[] readArray(String line) {
        return Arrays.stream(line.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}