package T01StacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P09InfixToPostfixv2_toRevise {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        ArrayDeque<String> operators = new ArrayDeque<>();
        ArrayDeque<String> expression = new ArrayDeque<>();
        Map<String,Integer> priorities = new HashMap<>();
        priorities.put("*", 3);
        priorities.put("/", 3);
        priorities.put("+", 2);
        priorities.put("-", 2);
        priorities.put("(", 1);

        for (String token : input) {
            try {
                double num = Double.parseDouble(token);
                expression.addLast(token);
            } catch (Exception e) {
                switch (token) {
                    case "x":
                        expression.addLast(token);
                        break;
                    case "(":
                        operators.push(token);
                        break;
                    case ")":
                        String symbol = operators.pop();
                        while (!symbol.equals("(")) {
                            expression.addLast(symbol);
                            symbol = operators.pop();
                        }
                        break;
                    default:
                        while (!operators.isEmpty() && priorities.get(operators.peek()) >= priorities.get(token)) {
                            expression.addLast(operators.pop());
                        }
                        operators.push(token);
                        break;
                }
            }
        }
        while (!operators.isEmpty()) {
            expression.addLast(operators.pop());
        }

        while (expression.size() > 0) {
            System.out.print(expression.pop()+" ");
        }
    }
}
