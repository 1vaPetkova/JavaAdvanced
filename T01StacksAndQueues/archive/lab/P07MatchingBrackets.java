package T01StacksAndQueues.archive.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07MatchingBrackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] split = input.split("");
        ArrayDeque<Integer> openStack = new ArrayDeque<>();
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("(")) {
                openStack.push(i);
            } else if (split[i].equals(")")) {
                System.out.println(input.substring(openStack.pop(), i + 1));
            }
        }

    }
}
