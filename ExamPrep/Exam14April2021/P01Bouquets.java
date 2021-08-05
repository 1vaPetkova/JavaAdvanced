package ExamPrep.Exam14April2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01Bouquets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> tulips = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(tulips::push);
        ArrayDeque<Integer> daffodils = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(daffodils::offer);
        int bouquets = 0;
        int flowersStored = 0;

        while (!daffodils.isEmpty() && !tulips.isEmpty()) {
            int sum = daffodils.peek() + tulips.peek();
            if (sum > 15) {
                while (sum > 15) {
                    tulips.push(tulips.pop() - 2);
                    sum = daffodils.peek() + tulips.peek();
                }
            }
            if (sum == 15) {
                bouquets++;
                daffodils.poll();
                tulips.pop();
                continue;
            }
            if (sum < 15) {
                flowersStored += daffodils.poll()+tulips.pop();
            }
        }
        bouquets += flowersStored / 15;
        if (bouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquets);
        }
    }
}
