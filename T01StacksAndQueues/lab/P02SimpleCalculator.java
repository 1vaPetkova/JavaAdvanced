package T01StacksAndQueues.lab;

import java.util.*;
import java.util.stream.Collectors;

public class P02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> expressions = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        Collections.reverse(expressions);

        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String expression : expressions) {
            stack.push(expression);
        }
        while (stack.size() > 1) {
            int leftOperand = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int rightOperand = Integer.parseInt(stack.pop());
            int result = operator.equals("+")
                    ? leftOperand + rightOperand
                    : leftOperand - rightOperand;
            stack.push(String.valueOf(result));
        }
        System.out.println(stack.pop());
    }
}
