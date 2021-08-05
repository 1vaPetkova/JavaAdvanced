package ExamPrep.Exam26June2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01OSPlanning {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(tasks::push);

        ArrayDeque<Integer> threads = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(threads::offer);
        int taskToBeKilled = Integer.parseInt(scan.nextLine());
        while (tasks.peek() != taskToBeKilled) {
            int currentTask = tasks.peek();
            int currentThread = threads.peek();
            if (currentThread >= currentTask) {
                tasks.pop();
                threads.poll();
            } else {
                threads.pop();
            }
        }
        System.out.printf("Thread with value %d killed task %d\n", threads.peek(), tasks.pop());
        threads.forEach(t -> System.out.print(t + " "));
    }
}
