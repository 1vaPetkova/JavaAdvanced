package ExamPrep.Exam17Dec2019;

import java.util.Scanner;

public class P02PresentDelivery {
    static int[] position;
    static int size;
    static int presentsCount;
    static int giftedPresents;
    static char[][] matrix;
    static int niceKids;
    static int naughtyKids;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        presentsCount = Integer.parseInt(scan.nextLine());
        size = Integer.parseInt(scan.nextLine());
        matrix = readNewMatrix(scan);
        position = getStartPosition();
        int allNiceKids = countNiceKids();
        niceKids = allNiceKids;
        naughtyKids = countNaughtyKids();
        emptyThePosition();
        String direction = "";
        while (!(direction = scan.nextLine()).equals("Christmas morning")) {
            move(direction);
            char current = matrix[position[0]][position[1]];
            switch (current) {
                //naughty kid
                case 'X':
                    emptyThePosition();
                    break;
                //nice kid
                case 'V':
                    niceKids--;
                    presentsCount--;
                    giftedPresents++;
                    emptyThePosition();
                    break;
                //cookie
                case 'C':
                    givePresentsToAllNeighbours();
                    break;
            }
            if (presentsCount <= 0) {
                break;
            }
        }

        matrix[position[0]][position[1]] = 'S';
        if (presentsCount <= 0 && giftedPresents - naughtyKids <= niceKids) {
            System.out.println("Santa ran out of presents!");
        }
        printMatrix();
        if (niceKids == 0) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.\n", allNiceKids);
        } else {
            System.out.printf("No presents for %d nice kid/s.\n", niceKids);
        }

    }

    private static void givePresentsToAllNeighbours() {
        //left
        givePresent(position[0], position[1] - 1);
        //right
        givePresent(position[0], position[1] + 1);
        //up
        givePresent(position[0] - 1, position[1]);
        //down
        givePresent(position[0] + 1, position[1]);
    }

    private static void givePresent(int newRow, int newCol) {
        char neighbourPosition = matrix[newRow][newCol];
        if (neighbourPosition == 'X' || neighbourPosition == 'V') {
            if (neighbourPosition == 'V') {
                niceKids--;
            }
            presentsCount--;
            giftedPresents++;
            matrix[newRow][newCol] = '-';
        }
    }


    public static boolean isOutOfBounds() {
        return position[0] < 0 || position[0] >= size
                || position[1] < 0 || position[1] >= size;
    }

    private static void move(String direction) {
        if (isOutOfBounds()) {
            presentsCount = 0;
            return;
        }
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

    public static void emptyThePosition() {
        matrix[position[0]][position[1]] = '-';
    }

    public static int countNaughtyKids() {
        int naughtyKids = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col] == 'X') {
                    naughtyKids++;
                }
            }
        }
        return naughtyKids;
    }

    public static int countNiceKids() {
        int niceKids = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col] == 'V') {
                    niceKids++;
                }
            }
        }
        return niceKids;
    }

    public static int[] getStartPosition() {
        int[] startPosition = new int[2];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col] == 'S') {
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
                System.out.print(element + " ");
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
