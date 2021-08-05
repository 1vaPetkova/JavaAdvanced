package ExamPrep.Exam28June2020;

import java.util.Scanner;

public class P02Snake {
    static int[] position;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        String[][] matrix = readNewMatrix(rows, scan);
        int food = 0;
        position = getStartPosition(matrix);
        leaveTrail(matrix);
        int[] burrowsPositions = findBurrowsPositions(matrix);
        boolean isGameOver = false;
        while (food < 10) {
            String direction = scan.nextLine();
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

            if (!isInBounds(matrix)) {
                isGameOver = true;
                break;
            } else if (hasSteppedOnAnEmptySpot(matrix)) {
                leaveTrail(matrix);
            } else if (hasFoundFood(matrix)) {
                food++;
                leaveTrail(matrix);
            } else if (isInFirstBurrow(matrix, burrowsPositions)) {
                leaveTrail(matrix);
                //goes to the secondBurrow
                position[0] = burrowsPositions[2];
                position[1] = burrowsPositions[3];
                leaveTrail(matrix);
            } else if (isInSecondBurrow(matrix, burrowsPositions)) {
                leaveTrail(matrix);
                //goes to the firstBurrow
                position[0] = burrowsPositions[0];
                position[1] = burrowsPositions[1];
                leaveTrail(matrix);
            }
        }
        if (isGameOver) {
            System.out.println("Game over!");
        } else {
            leaveSAtTheLastPosition(matrix);
            System.out.println("You won! You fed the snake.");
        }
        System.out.println("Food eaten: " + food);

        printMatrix(matrix);
    }


    public static void leaveSAtTheLastPosition(String[][] matrix) {
        matrix[position[0]][position[1]] = "S";
    }

    public static void leaveTrail(String[][] matrix) {
        matrix[position[0]][position[1]] = ".";
    }

    public static boolean hasSteppedOnAnEmptySpot(String[][] matrix) {
        if (matrix[position[0]][position[1]].equals("-")) {
            return true;
        }
        return false;
    }

    public static boolean hasFoundFood(String[][] matrix) {
        if (matrix[position[0]][position[1]].equals("*")) {
            return true;
        }
        return false;
    }

    public static boolean isInSecondBurrow(String[][] matrix, int[] burrowsPositions) {
        int sRow = burrowsPositions[2];
        int sCol = burrowsPositions[3];
        if (matrix[position[0]][position[1]].equals(matrix[sRow][sCol])) {
            return true;
        }
        return false;
    }

    public static boolean isInFirstBurrow(String[][] matrix, int[] burrowsPositions) {
        int fRow = burrowsPositions[0];
        int fCol = burrowsPositions[1];
        if (matrix[position[0]][position[1]].equals(matrix[fRow][fCol])) {
            return true;
        }
        return false;
    }

    public static int[] findBurrowsPositions(String[][] matrix) {
        int[] burrowsPosition = new int[4];//row1 col1 row2 col2
        int countBurrows = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("B")) {
                    countBurrows++;
                    if (countBurrows == 1) {
                        burrowsPosition[0] = row;
                        burrowsPosition[1] = col;
                    } else if (countBurrows == 2) {
                        burrowsPosition[2] = row;
                        burrowsPosition[3] = col;
                    }
                }
            }
        }
        return burrowsPosition;
    }

    public static int[] getStartPosition(String[][] matrix) {
        int[] startPosition = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("S")) {
                    startPosition[0] = row;
                    startPosition[1] = col;
                }
            }
        }
        return startPosition;
    }

    public static boolean isInBounds(String[][] matrix) {
        return position[0] >= 0 && position[0] < matrix.length
                && position[1] >= 0 && position[1] < matrix[position[0]].length;
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
