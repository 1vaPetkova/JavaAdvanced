package T01StacksAndQueues.archive.lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09MathPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> players = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        int tosses = Integer.parseInt(scan.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String player : players) {
            queue.offer(player);
        }
        int countCycles = 0;
        while (queue.size() > 1) {
            countCycles++;
            for (int i = 0; i < tosses - 1; i++) {
                queue.offer(queue.poll());
            }
            if (isPrime(countCycles)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }
        }
        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int num) {
        if (num == 0 || num == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
