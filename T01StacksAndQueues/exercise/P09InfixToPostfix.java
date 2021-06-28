package T01StacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P09InfixToPostfix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tokens = scan.nextLine().split(" ");
        ArrayDeque<String> outputQueue = new ArrayDeque<>();
        ArrayDeque<String> operatorStack = new ArrayDeque<>();
        for (String token : tokens) {
            if (!"+-/*()".contains(token)) {//if it is a number
                outputQueue.offer(token);
            } else if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals(")")) {
                while(!operatorStack.peek().equals("(")){
                    outputQueue.offer(operatorStack.pop());
                }
                operatorStack.pop();//get rid of the left bracket
            } else {
                if ("+-".contains(token)) {
                    while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                        outputQueue.offer(operatorStack.pop());
                    }
                } else {
                    while (!operatorStack.isEmpty() && !"+-(".contains(operatorStack.peek())) {
                        outputQueue.offer(operatorStack.pop());
                    }
                }
                operatorStack.push(token);
            }
        }
        while (!operatorStack.isEmpty()) {
            outputQueue.offer(operatorStack.pop());
        }
        System.out.print(String.join(" ", outputQueue));
    }
}

