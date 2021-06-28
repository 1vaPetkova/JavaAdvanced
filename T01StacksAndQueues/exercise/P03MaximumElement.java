package T01StacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P03MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int commands = Integer.parseInt(scan.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < commands; i++) {
            switch (scan.nextInt()) {
                case 1:
                    stack.push(scan.nextInt());
                    break;
                case 2:
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                case 3:
                    if (!stack.isEmpty()) {
                        System.out.println(Collections.max(stack));
                    }
                    break;
            }
        }
    }
}
