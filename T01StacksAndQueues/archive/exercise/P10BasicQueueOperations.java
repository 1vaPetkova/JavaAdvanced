package T01StacksAndQueues.archive.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P10BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int elementsToOffer = scan.nextInt();
        int elementsToPoll = scan.nextInt();
        int elementToCheck = scan.nextInt();

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        while (elementsToOffer-- > 0) {
            queue.offer(scan.nextInt());
        }
        while (elementsToPoll-- > 0) {
            queue.pop();
        }

        boolean isInStack = queue.contains(elementToCheck);
        if (isInStack) {
            System.out.println(true);
        } else if (queue.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(queue.stream().min(Comparable::compareTo).get());
        }
    }
}
