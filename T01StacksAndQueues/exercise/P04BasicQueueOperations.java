package T01StacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int elementsToOffer = scan.nextInt();
        int elementsToPoll = scan.nextInt();
        int elementToCheck = scan.nextInt();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < elementsToOffer; i++) {
            queue.offer(scan.nextInt());
        }

        for (int i = 0; i < elementsToPoll; i++) {
            queue.poll();
        }

        if (queue.contains(elementToCheck)) {
            System.out.println("true");
        } else if (queue.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(Collections.min(queue));
        }
    }
}