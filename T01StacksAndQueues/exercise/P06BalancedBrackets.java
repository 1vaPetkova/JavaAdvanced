package T01StacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P06BalancedBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        ArrayDeque<String> openBrackets = new ArrayDeque<>();
        ArrayDeque<String> closedBrackets = new ArrayDeque<>();
        if (input.length() % 2 != 0) {
            System.out.println("NO");
        } else {
            for (int i = 0; i < input.length(); i++) {
                char currentBracket = input.charAt(i);
                if (isOpen(currentBracket)) {
                    openBrackets.push(String.valueOf(currentBracket));
                } else if (isClosed(currentBracket)) {
                    closedBrackets.offer(opposite(currentBracket));
                }
            }
            boolean isBalanced = false;
            for (int i = 0; i < closedBrackets.size(); i++) {
                if (openBrackets.pop().equals(closedBrackets.poll())) {
                    isBalanced = true;
                } else {
                    isBalanced = false;
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

    private static String opposite(Character ch) {
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
        return String.valueOf(opposite);
    }
}
