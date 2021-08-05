package ExamPrep.Exam20Feb2021;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02Bomb {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        List<String> directions = Arrays.stream(scan.nextLine().split(","))
                .collect(Collectors.toList());

        String[][] matrix = readNewMatrix(rows, scan);
        int[] position = getStartPosition(matrix);//position[0]=row; position[1]=col;
        int startBombs = findBombsInMatrix(matrix);
        int bombsDeactivated = 0;
        boolean isProgramOver = false;
        for (String direction : directions) {
            int[] newPosition = new int[2];
            switch (direction) {
                case "left":
                    newPosition[0] = position[0];
                    newPosition[1] = position[1] - 1;
                    break;
                case "right":
                    newPosition[0] = position[0];
                    newPosition[1] = position[1] + 1;
                    break;
                case "up":
                    newPosition[0] = position[0] - 1;
                    newPosition[1] = position[1];
                    break;
                case "down":
                    newPosition[0] = position[0] + 1;
                    newPosition[1] = position[1];
                    break;
            }
            if (isInBounds(newPosition, matrix)) {
                if (isEndOfRoute(matrix, newPosition)) {
                    isProgramOver = true;
                    break;
                } else {
                    bombsDeactivated = moveSapper(matrix, newPosition, bombsDeactivated);
                }
            } else {
                continue;
            }

            position = newPosition;
        }
        if (bombsDeactivated == startBombs) {
            System.out.println("Congratulations! You found all bombs!");
        } else if (isProgramOver) {
            System.out.printf("END! %d bombs left on the field\n", startBombs - bombsDeactivated);
        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)",
                    startBombs - bombsDeactivated, position[0], position[1]);
        }
    }


    public static boolean isEndOfRoute(String[][] matrix, int[] newPosition) {
        if (matrix[newPosition[0]][newPosition[1]].equals("e")) {
            return true;
        }
        return false;
    }

    public static int moveSapper(String[][] matrix, int[] newPosition, int bombsDeactivated) {
        if (matrix[newPosition[0]][newPosition[1]].equals("B")) {
            matrix[newPosition[0]][newPosition[1]] = "+";
            System.out.println("You found a bomb!");
            bombsDeactivated++;
        }
        return bombsDeactivated;
    }

    public static int findBombsInMatrix(String[][] matrix) {
        int countBombs = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("B")) {
                    countBombs++;
                }
            }
        }
        return countBombs;
    }

    public static int[] getStartPosition(String[][] matrix) {
        int[] startPosition = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("s")) {
                    startPosition[0] = row;
                    startPosition[1] = col;
                }
            }
        }
        return startPosition;
    }


    public static boolean isInBounds(int[] position, String[][] matrix) {
        return position[0] >= 0 && position[0] < matrix.length
                && position[1] >= 0 && position[1] < matrix[position[0]].length;
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] arr : matrix) {
            for (String element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static String[][] readNewMatrix(int rows, Scanner scan) {
        String[][] matrix = new String[rows][rows];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scan.nextLine().split("\\s+");
        }
        return matrix;
    }
}

