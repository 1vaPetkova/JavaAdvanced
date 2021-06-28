package T01StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P06HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] kids = scan.nextLine().split("\\s+");
        int passes = Integer.parseInt(scan.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (String s : kids) {
            queue.offer(s);
        }
        while (queue.size() > 1) {
            for (int i = 1; i < passes; i++) {
                queue.offer(queue.poll());
            }
                System.out.println("Removed " + queue.poll());
        }
        System.out.println("Last is " + queue.poll());
    }
}
