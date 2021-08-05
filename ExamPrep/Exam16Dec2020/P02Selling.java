package ExamPrep.Exam16Dec2020;

import java.util.Scanner;

public class P02Selling {
    static int[] position;
    static int rows;
    static char[][] matrix;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        rows = Integer.parseInt(scan.nextLine());
        matrix = readNewMatrix(scan);
        position = getStartPosition();
        matrix[position[0]][position[1]] = '-';
        int amount = 0;
        boolean isOutOfTheBakery = false;
        while (amount < 50) {
            String direction = scan.nextLine();
            move(direction);
            if (isOutOfBounds()) {
                isOutOfTheBakery = true;
                break;
            }
            char currentElement = matrix[position[0]][position[1]];
            if (Character.isDigit(currentElement)) {
                amount += Integer.parseInt(String.valueOf(currentElement));
                matrix[position[0]][position[1]] = '-';
            } else if (currentElement == 'O') {
                matrix[position[0]][position[1]] = '-';
                position = findOtherPillar();
                matrix[position[0]][position[1]] = '-';
            }
        }
        if (isOutOfTheBakery) {
            System.out.println("Bad news, you are out of the bakery.");
        } else {
            matrix[position[0]][position[1]] = 'S';
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.println("Money: " + amount);
        printMatrix();
    }

    private static int[] findOtherPillar() {
        int[] pillarPosition = new int[2];
        boolean isFound = false;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                if (matrix[row][col] == 'O') {
                    pillarPosition[0] = row;
                    pillarPosition[1] = col;
                    isFound = true;
                    break;
                }
            }
            if (isFound) {
                break;
            }
        }
        return pillarPosition;
    }

    private static void move(String direction) {
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
                if (matrix[row][col] == 'S') {
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