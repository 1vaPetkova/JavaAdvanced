package ExamPrep.Exam26Oct2019;

import java.util.Scanner;

public class P02BookWorm {
    static int[] position;
    static int rows;
    static char[][] matrix;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        sb = new StringBuilder(scan.nextLine());
        rows = Integer.parseInt(scan.nextLine());
        matrix = readNewMatrix(scan);
        position = getStartPosition();
        emptyThePosition();
        String input = "";
        while (!(input = scan.nextLine()).equals("end")) {
            position = move(input);
            if (isOutOfBounds()) {
                sb.deleteCharAt(sb.length() - 1);
                position = move(getOppositeDirection(input));
            } else {
                char currentSymbol = matrix[position[0]][position[1]];
                if (Character.isLetter(currentSymbol)) {
                    sb.append(currentSymbol);
                    emptyThePosition();
                }
            }
        }
       matrix[position[0]][position[1]]='P';
            System.out.println(sb);
            printMatrix();
    }



    public static void emptyThePosition() {
        matrix[position[0]][position[1]] = '-';
    }
    private static String getOppositeDirection(String command) {
        switch (command) {
            case "left":
                command = "right";
                break;
            case "right":
                command = "left";
                break;
            case "up":
                command = "down";
                break;
            case "down":
                command = "up";
                break;
        }
        return command;
    }


    private static int[] move(String command) {
        int[] newPosition = position;
        switch (command) {
            case "left":
                newPosition[1]--;
                break;
            case "right":
                newPosition[1]++;
                break;
            case "up":
                newPosition[0]--;
                break;
            case "down":
                newPosition[0]++;
                break;
        }
        return newPosition;
    }

    public static boolean isOutOfBounds() {
        return position[0] < 0 || position[0] >= rows
                || position[1] < 0 || position[1] >= rows;
    }

    public static int[] getStartPosition() {
        int[] startPosition = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'P') {
                    startPosition[0] = row;
                    startPosition[1] = col;
                }
            }
        }
        return startPosition;
    }

    private static void printMatrix() {
        for (char[] arr : matrix) {
            for (char element : arr) {
                System.out.print(element);
            }
            System.out.println();
        }
    }

    private static char[][] readNewMatrix(Scanner scan) {
        char[][] matrix = new char[rows][rows];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scan.nextLine().toCharArray();
        }
        return matrix;
    }
}
