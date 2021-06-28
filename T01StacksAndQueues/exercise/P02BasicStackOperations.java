package T01StacksAndQueues.exercise;

import java.util.*;


public class P02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int elementsToPush = scan.nextInt();
        int elementsToPop = scan.nextInt();
        int elementToCheck = scan.nextInt();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < elementsToPush; i++) {
            stack.push(scan.nextInt());
        }

        for (int i = 0; i < elementsToPop; i++) {
            stack.pop();
        }

        if (stack.contains(elementToCheck)) {
            System.out.println("true");
        } else if (stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(Collections.min(stack));
        }
    }
}
