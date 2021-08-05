package T01StacksAndQueues.archive.exercise;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Scanner;

public class P08BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int elementsToPush = scan.nextInt();
        int elementsToPop = scan.nextInt();
        int elementToCheck = scan.nextInt();

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        while (elementsToPush-- > 0) {
            stack.push(scan.nextInt());
        }
        while (elementsToPop-- > 0) {
            stack.pop();
        }

        boolean isInStack = stack.contains(elementToCheck);
        if (isInStack) {
            System.out.println(true);
        } else if (stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(stack.stream().min(Comparable::compareTo).get());
        }
    }
}
