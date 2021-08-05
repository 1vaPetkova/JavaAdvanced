package T02MultidimentionalArrays.exercise;

import java.util.Scanner;

public class P08TheHeiganDancev2 {
    static int[] position = new int[2];
    static int[][] matrix = new int[15][15];
    static int[] spell = new int[2];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double damage = Double.parseDouble(scan.nextLine());
        double playerHealth = 18500;
        double heiganHealth = 3000000;
        position[0] = 7;
        position[1] = 7;

        boolean isCloudActive = false;
        String lastSpell = "";
        while (playerHealth > 0) {
            heiganHealth -= damage;
            if (isCloudActive) {
                playerHealth -= 3500;
                isCloudActive = false;
                if (playerHealth <= 0) {
                    break;
                }
            }
            if (heiganHealth <= 0) {
                break;
            }

            String input = scan.nextLine();
            String spellName = input.split("\\s+")[0];
            spell[0] = Integer.parseInt(input.split("\\s+")[1]);
            spell[1] = Integer.parseInt(input.split("\\s+")[2]);

            int damageDone = 0;
            if (isInTheSpellRange(position[0], position[1])) {
                if (spellName.equals("Cloud")) {
                    damageDone = 3500;
                } else {
                    damageDone = 6000;
                }
                boolean canMove = playerCanMoveAndMovePlayer();
                if (!canMove) {
                    playerHealth -= damageDone;
                    if (spellName.equals("Cloud")) {
                        isCloudActive = true;
                    }
                }
            }
            lastSpell = spellName;
        }

        if (heiganHealth > 0) {
            System.out.printf("Heigan: %.2f\n", heiganHealth);
        } else {
            System.out.println("Heigan: Defeated!");
        }
        if (playerHealth <= 0) {
            lastSpell = lastSpell.equals("Cloud") ? "Plague Cloud" : lastSpell;
            System.out.printf("Player: Killed by %s\n", lastSpell);
        } else {
            System.out.printf("Player: %.0f\n", playerHealth);
        }
        System.out.printf("Final position: %d, %d%n", position[0], position[1]);
    }

    private static boolean playerCanMoveAndMovePlayer() {
        boolean canMove = false;
        //Up Right Down Left
        int r = position[0];
        int c = position[1];
        //UP
        if (isInBounds(r - 1, c) && !isInTheSpellRange(r - 1, c)) {
            r--;
            canMove = true;
            //RIGHT
        } else if (isInBounds(r, c + 1) && !isInTheSpellRange(r, c + 1)) {
            c++;
            canMove = true;
            //DOWN
        } else if (isInBounds(r + 1, c) && !isInTheSpellRange(r + 1, c)) {
            r++;
            canMove = true;
            //LEFT
        } else if (isInBounds(r, c - 1) && !isInTheSpellRange(r, c - 1)) {
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

    private static boolean isInTheSpellRange(int r, int c) {
        return r >= spell[0] - 1 && r <= spell[0] + 1
                && c >= spell[1] - 1 && c <= spell[1] + 1;

    }
}
