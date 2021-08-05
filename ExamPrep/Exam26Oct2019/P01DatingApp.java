package ExamPrep.Exam26Oct2019;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01DatingApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> males = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(males::push);

        ArrayDeque<Integer> females = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(females::offer);
        int matches = 0;
        while (!males.isEmpty() && !females.isEmpty()) {
            int f = females.peek();
            int m = males.peek();
            if (f <= 0) {
                females.poll();
                continue;
            }
            if (m <= 0) {
                males.pop();
                continue;
            }
            if (f % 25 == 0) {
                females.poll();
                females.poll();
                continue;
            }
            if (m % 25 == 0) {
                males.pop();
                males.pop();
                continue;
            }
            if (f == m) {
                matches++;
                females.poll();
                males.pop();
            } else {
                females.poll();
                males.push(males.pop()-2);
            }
        }
        System.out.println("Matches: " + matches);
        if (males.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.println("Males left: " +
                    males.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        if (females.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.println("Females left: " +
                    females.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }
}

