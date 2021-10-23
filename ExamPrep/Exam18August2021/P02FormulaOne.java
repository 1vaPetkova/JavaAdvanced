package ExamPrep.Exam18August2021;

import java.util.Scanner;

public class P02FormulaOne {
    static int[] position;
    static int size;
    static char[][] matrix;
    static boolean hasFinished;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        size = Integer.parseInt(scan.nextLine());
        int commands  = Integer.parseInt(scan.nextLine());
        matrix = readNewMatrix(scan);
        position = getStartPosition();
        emptyThePosition();
        hasFinished = false;
        while (commands-- > 0) {
            String direction = scan.nextLine();
            checkIndexAndMove(direction);
            switch (matrix[position[0]][position[1]]) {
                case 'B':
                    checkIndexAndMove(direction);
                    if (matrix[position[0]][position[1]]=='F') {
                        hasFinished = true;
                    }
                    break;
                case 'T':
                    checkIndexAndMove(getOppositeCommand(direction));
                    break;
                case 'F':
                    hasFinished = true;
                    break;
            }
            if (hasFinished) {
                break;
            }
        }
       matrix[position[0]][position[1]] = 'P';
        if (hasFinished) {
            System.out.println("Well done, the player won first place!");
        } else  {
            System.out.println("Oh no, the player got lost on the track!");
        }
        printMatrix();
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

    private static void checkIndexAndMove(String direction) {
        switch (direction) {
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
        if (isOutOfBounds()){
        moveOppositeIfOutOfBounds();
        }
    }

    public static void moveOppositeIfOutOfBounds() {
            if (position[0] < 0) {
                position[0] = size - 1;
            } else if (position[0] >= size) {
                position[0] = 0;
            } else if (position[1] < 0) {
                position[1] = size - 1;
            } else if (position[1] >= size) {
                position[1] = 0;
            }
    }

    public static boolean isOutOfBounds() {
        return position[0] < 0 || position[0] >= size
                || position[1] < 0 || position[1] >= size;
    }

    public static void emptyThePosition() {
        matrix[position[0]][position[1]] = '.';
    }

    public static int[] getStartPosition() {
        int[] startPosition = new int[2];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
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
        char[][] matrix = new char[size][size];
        for (int row = 0; row < size; row++) {
            matrix[row] = scan.nextLine().replaceAll(" ", "").toCharArray();
        }
        return matrix;
    }
}
