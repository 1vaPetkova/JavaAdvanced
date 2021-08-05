package T01StacksAndQueues.archive.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

public class P12BalancedParentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        String[] brackets = scan.nextLine().split("");
        boolean isBalanced = true;
        if (brackets.length % 2 != 0) {
            isBalanced = false;
        } else {
            for (int i = 0; i < brackets.length; i++) {
                if (isOpen(brackets[i])) {
                    stack.push(brackets[i]);
                } else if (isClosed(brackets[i])) {
                    queue.offer(brackets[i]);
                }
            }
            if (queue.isEmpty() || stack.isEmpty()) {
                isBalanced = false;
            }
            for (int i = 0; i < stack.size(); i++) {
                isBalanced = stack.pop().equals(getOpposite(queue.poll()));
            }
        }
        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }


    private static String getOpposite(String bracket) {
        String opposite = "";
        switch (bracket) {
            case "}":
                opposite = "{";
                break;
            case "]":
                opposite = "[";
                break;
            case ")":
                opposite = "(";
                break;
        }
        return opposite;
    }

    private static boolean isClosed(String bracket) {
        switch (bracket) {
            case "}":
            case "]":
            case ")":
                return true;
        }
        return false;
    }

    private static boolean isOpen(String bracket) {
        switch (bracket) {
            case "{":
            case "[":
            case "(":
                return true;
        }
        return false;
    }
}
