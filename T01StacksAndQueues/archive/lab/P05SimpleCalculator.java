package T01StacksAndQueues.archive.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = input.length - 1; i >= 0; i--) {
            stack.push(input[i]);
        }

        int result = Integer.parseInt(stack.pop());
        while (!stack.isEmpty()) {
            String operator = stack.pop();
            int secondNumber = Integer.parseInt(stack.pop());
            if (operator.equals("+")) {
                result += secondNumber;
            } else {
                result -= secondNumber;
            }
        }
        System.out.println(result);
    }
}
