package T01StacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P06BalancedBracketsv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        ArrayDeque<Character> openBrackets = new ArrayDeque<>();
        if (input.length() % 2 != 0) {
            System.out.println("NO");
        } else {
            boolean isBalanced = false;
            for (int i = 0; i < input.length(); i++) {
                char currentBracket = input.charAt(i);
                if (isOpen(currentBracket)) {
                    openBrackets.push(currentBracket);
                } else if (isClosed(currentBracket)) {
                    if (openBrackets.isEmpty()) {
                        isBalanced = false;
                        break;
                    } else if (openBrackets.pop() == opposite(currentBracket)) {
                        isBalanced = true;
                    } else {
                        isBalanced = false;
                        break;
                    }
                }
            }

            if (isBalanced) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isClosed(char currentBracket) {
        switch (currentBracket) {
            case '}':
            case ')':
            case ']':
                return true;
        }
        return false;
    }


    private static boolean isOpen(char currentBracket) {
        switch (currentBracket) {
            case '{':
            case '(':
            case '[':
                return true;
        }
        return false;
    }

    private static Character opposite(Character ch) {
        char opposite = ' ';
        switch (ch) {
            case '}':
                opposite = '{';
                break;
            case ']':
                opposite = '[';
                break;
            case ')':
                opposite = '(';
                break;

        }
        return opposite;
    }
}
