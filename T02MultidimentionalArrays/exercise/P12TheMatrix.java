package T02MultidimentionalArrays.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P12TheMatrix {
    public static class TheMatrix {
        private char[][] matrix;
        private char fillChar;
        private char startChar;
        private int startRow;
        private int startCol;

        public TheMatrix(char[][] matrix, char fillChar, int startRow, int startCol) {
            this.matrix = matrix;
            this.fillChar = fillChar;
            this.startRow = startRow;
            this.startCol = startCol;
            this.startChar = this.matrix[this.startRow][this.startCol];
        }

        public void solve() {//DFS
            this.fillMatrix(this.startRow, this.startCol);
        }

        private void fillMatrix(int row, int col) {

            if (this.isInMatrix(row, col) && this.matrix[row][col] == startChar) { //adding recursion bottom
                this.matrix[row][col] = this.fillChar;

                this.fillMatrix(row + 1, col);
                this.fillMatrix(row, col + 1);
                this.fillMatrix(row - 1, col);
                this.fillMatrix(row, col - 1);
            }
        }

        private boolean isInMatrix(int row, int col) {
            return row >= 0 && row < this.matrix.length && col >= 0 && col < this.matrix[row].length;
        }

        public String toOutputString() {
            StringBuilder sb = new StringBuilder();
            for (int r = 0; r < this.matrix.length; r++) {
                for (int c = 0; c < this.matrix[r].length; c++) {
                    sb.append(this.matrix[r][c]);
                }
                sb.append(System.lineSeparator());
            }
            return sb.toString().trim();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] rowsAndCols = readArray(scan.nextLine());

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];
        List<String> elements = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            elements.add(scan.nextLine().replaceAll("\\s+", ""));
        }
        char[][] matrix = getBaseMatrix(rows, cols, elements);
        //  printMatrix(matrix);
        char fillChar = scan.nextLine().charAt(0);
        int[] startCoordinates = readArray(scan.nextLine());
        int startRow = startCoordinates[0];
        int startCol = startCoordinates[1];

        TheMatrix newMatrix = new TheMatrix(matrix, fillChar, startRow, startCol);
        newMatrix.solve();

        String output = newMatrix.toOutputString();
        System.out.println(output);
    }

    private static char[][] getBaseMatrix(int rows, int cols, List<String> elements) {
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (elements.get(row).length() > col) {
                    matrix[row][col] = elements.get(row).charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }
        return matrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }


    public static int[] readArray(String line) {
        return Arrays.stream(line.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
