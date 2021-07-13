package T02MultidimentionalArrays.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P07Crossfire {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] rowsAndCols = readArray(scan.nextLine());

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];
        List<List<Integer>> matrix = readMatrix(rows, cols);

        String input = "";
        while (!(input = scan.nextLine()).equals("Nuke it from orbit")) {
            int[] tokens = readArray(input);
            int targetRow = tokens[0];
            int targetCol = tokens[1];
            int radius = tokens[2];

            getDetonatedMatrix(targetRow,targetCol,radius,matrix);
        }
        printMatrix(matrix);
    }

    private static void getDetonatedMatrix(int targetRow, int targetCol, int radius, List<List<Integer>> matrix) {
        for (int row = targetRow - radius; row <= targetRow + radius; row++) {
            if (isInBounds(row, targetCol, matrix)) {
                matrix.get(row).set(targetCol, 0);
            }
        }
        for (int col = targetCol - radius; col <= targetCol + radius; col++) {
            if (isInBounds(targetRow, col, matrix)) {
                matrix.get(targetRow).set(col, 0);
            }
        }

        for (int row = 0; row < matrix.size(); row++) {
            matrix.get(row).removeAll(List.of(0));
            if (matrix.get(row).size() == 0) {
                matrix.remove(row);
                row--;
            }
        }
    }


    public static boolean isInBounds(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> list : matrix) {
            for (int element : list) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> readMatrix(int rows, int cols) {
        List<List<Integer>> matrix = new ArrayList<>();
        int element = 1;
        for (int row = 0; row < rows; row++) {
            List<Integer> currentRow = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                currentRow.add(element);
                element++;
            }
            matrix.add(currentRow);
        }
        return matrix;
    }


    public static int[] readArray(String line) {
        return Arrays.stream(line.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
