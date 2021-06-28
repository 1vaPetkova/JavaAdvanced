package T01StacksAndQueues.lab;

import java.util.*;
import java.util.stream.Collectors;

public class P04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char element = input.charAt(i);
            if (element == '(') {
                stack.push(i);
            } else if (element == ')') {
                int openIndex = stack.pop();
                String subExpression = input.substring(openIndex, i+1);
                System.out.println(subExpression);
            }
        }
    }
}
