package T01StacksAndQueues.archive.lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P08HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> players = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        int tosses = Integer.parseInt(scan.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String player : players) {
            queue.offer(player);
        }
        while (queue.size() > 1) {

            for (int i = 0; i < tosses - 1; i++) {
                queue.offer(queue.poll());
            }
            System.out.println("Removed " + queue.poll());
        }
        System.out.println("Last is " + queue.poll());
    }
}
