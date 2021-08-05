package ExamPrep.Exam26June2021;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02Python {
    static int[] position = new int[2];
    static int rows;
    static int length;
    static char[][] matrix = new char[rows][rows];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        rows = Integer.parseInt(scan.nextLine());
        List<String> directions = Arrays.stream(scan.nextLine().split(", "))
                .collect(Collectors.toList());
        matrix = readNewMatrix(scan);
        position = getStartPosition();
        length = 1;
        boolean isOver = false;
        for (String direction : directions) {
            checkIndexAndMove(direction);
            switch (matrix[position[0]][position[1]]) {
                case 'e':
                    isOver = true;
                    break;
                case 'f':
                    matrix[position[0]][position[1]] = '*';
                    length++;
                    break;
                case '*':
                case 's':
                    continue;
            }
            if (isOver) {
                break;
            }
        }
        if (isOver) {
            System.out.println("You lose! Killed by an enemy!");
        } else if (findFoodLeft() > 0) {
            System.out.printf("You lose! There is still %d food to be eaten.", findFoodLeft());
        } else {
            System.out.println("You win! Final python length is " + length);
        }
    }

    public static int findFoodLeft() {
        int countFood = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                if (matrix[row][col] == 'f') {
                    countFood++;
                }
            }
        }
        return countFood;
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

    public static int[] getStartPosition() {
        int[] startPosition = new int[2];
        boolean isFound = false;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                if (matrix[row][col] == 's') {
                    startPosition[0] = row;
                    startPosition[1] = col;
                    isFound = true;
                    break;
                }
            }
            if (isFound) {
                break;
            }
        }
        return startPosition;
    }

    private static void printMatrix() {
        for (char[] arr : matrix) {
            for (char element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static char[][] readNewMatrix(Scanner scan) {
        char[][] matrix = new char[rows][rows];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scan.nextLine().replaceAll(" ", "").toCharArray();
        }
        return matrix;
    }
}
