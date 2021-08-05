package ExamPrep.Exam22Feb2020;

import java.util.Scanner;

public class P02ReVolt {
    static int[] position;
    static int rows;
    static boolean hasFinished;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        rows = Integer.parseInt(scan.nextLine());
        int lines = Integer.parseInt(scan.nextLine());
        String[][] matrix = readNewMatrix(rows, scan);
        position = getStartPosition(matrix);
        matrix[position[0]][position[1]] = "-";
        hasFinished = false;
        while (lines-- > 0) {
            String command = scan.nextLine();
            checkIndexAndMove(command);
            switch (matrix[position[0]][position[1]]) {
                case "B":
                    checkIndexAndMove(command);
                    if (matrix[position[0]][position[1]].equals("F")) {
                        hasFinished = true;
                    }
                    break;
                case "T":
                    checkIndexAndMove(getOppositeCommand(command));
                    break;
                case "F":
                    hasFinished = true;
                    break;
            }

            if (hasFinished) {
                break;
            }
        }
        matrix[position[0]][position[1]] = "f";
        if (hasFinished) {
            System.out.println("Player won!");
        } else if (lines <= 0) {
            System.out.println("Player lost!");
        }
        printMatrix(matrix);
    }

    private static String getOppositeCommand(String command) {
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

    private static void checkIndexAndMove(String command) {
        switch (command) {
            case "left":
                position[1]--;
                break;
            case "right":
                position[1]++;
                break;
            case "up":
                position[0]--;
                break;
            case "down":
                position[0]++;
                break;
        }
        moveOppositeIfOutOfBounds();
    }

    public static void moveOppositeIfOutOfBounds() {
        if (isOutOfBounds()) {
            if (position[0] < 0) {
                position[0] = rows - 1;
            } else if (position[0] >= rows) {
                position[0] = 0;
            } else if (position[1] < 0) {
                position[1] = rows - 1;
            } else if (position[1] >= rows) {
                position[1] = 0;
            }
        }
    }


    public static boolean isOutOfBounds() {
        return position[0] < 0 || position[0] >= rows
                || position[1] < 0 || position[1] >= rows;
    }

    public static int[] getStartPosition(String[][] matrix) {
        int[] startPosition = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("f")) {
                    startPosition[0] = row;
                    startPosition[1] = col;
                }
            }
        }
        return startPosition;
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] arr : matrix) {
            for (String element : arr) {
                System.out.print(element);
            }
            System.out.println();
        }
    }

    private static String[][] readNewMatrix(int rows, Scanner scan) {
        String[][] matrix = new String[rows][rows];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scan.nextLine().split("");
        }
        return matrix;
    }
}
