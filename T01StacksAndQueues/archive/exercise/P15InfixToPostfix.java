package T01StacksAndQueues.archive.exercise;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P15InfixToPostfix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tokens = scan.nextLine().split(" ");
        ArrayDeque<String> outputQueue = new ArrayDeque<>();
        ArrayDeque<String> operatorsStack = new ArrayDeque<>();
        Map<String, Integer> priorities = getPriorities();

        for (String t : tokens) {
            try {
                double num = Double.parseDouble(t);//if it is a number
                outputQueue.offer(t);
            } catch (Exception E) {
                if (Character.isLetter(t.charAt(0))) {
                    outputQueue.offer(t);
                } else if (t.equals("(")) {
                    operatorsStack.push(t);
                } else if (t.equals(")")) {
                    while (!operatorsStack.peek().equals("(")) {
                        outputQueue.offer(operatorsStack.pop());
                    }
                    operatorsStack.pop();//get rid of the left bracket
                } else {
                    while (!operatorsStack.isEmpty() && priorities.get(operatorsStack.peek()) >= priorities.get(t)) {
                        outputQueue.offer(operatorsStack.pop());
                    }
                    operatorsStack.push(t);
                }
            }
        }
        while (!operatorsStack.isEmpty()) {
            outputQueue.offer(operatorsStack.pop());
        }
        System.out.println(String.join(" ", outputQueue));

    }

    private static Map<String, Integer> getPriorities() {
        Map<String, Integer> priorities = new HashMap<>();
        priorities.put("(", 1);
        priorities.put("+", 2);
        priorities.put("-", 2);
        priorities.put("*", 3);
        priorities.put("/", 3);
        return priorities;
    }
}
