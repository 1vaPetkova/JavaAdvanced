package ExamPrep.Exam20Feb2021;

import java.util.*;

public class P01MagicBox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> firstMagicBox = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(firstMagicBox::offer);

        ArrayDeque<Integer> secondMagicBox = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(secondMagicBox::push);
        List<Integer> claimedItems = new ArrayList<>();
        while (!firstMagicBox.isEmpty() && !secondMagicBox.isEmpty()) {
            int sum = firstMagicBox.peek() + secondMagicBox.peek();
            if (sum % 2 == 0) {
                claimedItems.add(sum);
                firstMagicBox.poll();
                secondMagicBox.pop();
            } else {
                int lastItem = secondMagicBox.pop();
                firstMagicBox.offer(lastItem);
            }
        }
        if (firstMagicBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else {
            System.out.println("Second magic box is empty.");
        }
        int sumClaimedItems = claimedItems.stream().mapToInt(e -> e).sum();
        if (sumClaimedItems >= 90) {
            System.out.println("Wow, your prey was epic! Value: " + sumClaimedItems);
        } else {
            System.out.println("Poor prey... Value: " + sumClaimedItems);
        }
    }
}
