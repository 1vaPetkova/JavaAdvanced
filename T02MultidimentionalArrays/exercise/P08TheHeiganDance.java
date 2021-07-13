package T02MultidimentionalArrays.exercise;

import java.util.Scanner;

public class P08TheHeiganDance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int playerHealth = 18500;
        double bossHealth = 3000000;
        double damage = Double.parseDouble(scan.nextLine());

        int[] playerPos = new int[2];
        playerPos[0] = 7;
        playerPos[1] = 7;

        boolean isInCloud = false;
        String lastSpell = "";
        while (playerHealth > 0) {

            bossHealth -= damage;
            if (isInCloud) {
                playerHealth -= 3500;
                isInCloud = false;
            }
            if (playerHealth <= 0) {
                lastSpell = "Cloud";
                break;
            }
            if (bossHealth <= 0) {
                break;
            }
            String[] tokens = scan.nextLine().split("\\s+");
            String spell = tokens[0];
            int targetRow = Integer.parseInt(tokens[1]);
            int targetCol = Integer.parseInt(tokens[2]);

            int damageDone = 0;
            if (isPlayerHit(playerPos[0], playerPos[1], targetRow, targetCol)) {
                if (spell.equals("Cloud")) {
                    damageDone = 3500;
                } else {
                    damageDone = 6000;
                }
                boolean canMove = playerCanMoveAndMovePlayer(playerPos, targetRow, targetCol);
                if (!canMove) {
                    playerHealth -= damageDone;
                    if (spell.equals("Cloud")) {
                        isInCloud = true;
                    }
                }
            }
            lastSpell = spell;
        }
        if (bossHealth > 0) {
            System.out.printf("Heigan: %.2f\n", bossHealth);
        } else {
            System.out.println("Heigan: Defeated!");
        }
        if (playerHealth <= 0) {
            lastSpell = lastSpell.equals("Cloud") ? "Plague Cloud" : lastSpell;
            System.out.printf("Player: Killed by %s\n", lastSpell);
        } else {
            System.out.printf("Player: %d\n", playerHealth);
        }
        System.out.println(String.format("Final position: %d, %d", playerPos[0], playerPos[1]));
    }

    private static boolean playerCanMoveAndMovePlayer(int[] position, int row, int col) {
        boolean canMove = false;
        //Up Right Down Left
        int r = position[0];
        int c = position[1];
        //UP
        if (isInBounds(r - 1, c) && !isPlayerHit(r - 1, c, row, col)) {
            r--;
            canMove = true;
            //RIGHT
        } else if (isInBounds(r, c + 1) && !isPlayerHit(r, c + 1, row, col)) {
            c++;
            canMove = true;
            //DOWN
        } else if (isInBounds(r + 1, c) && !isPlayerHit(r + 1, c, row, col)) {
            r++;
            canMove = true;
            //LEFT
        } else if (isInBounds(r, c - 1) && !isPlayerHit(r, c - 1, row, col)) {
            c--;
            canMove = true;
        }
        position[0] = r;
        position[1] = c;
        return canMove;
    }

    private static boolean isInBounds(int r, int c) {
        return r >= 0 && r < 15 && c >= 0 && c < 15;
    }

    private static boolean isPlayerHit(int r, int c, int targetRow, int targetCol) {
        return r >= targetRow - 1 && r <= targetRow + 1
                && c >= targetCol - 1 && c <= targetCol + 1;
    }
}
