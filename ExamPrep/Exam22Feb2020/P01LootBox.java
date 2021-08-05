package ExamPrep.Exam22Feb2020;

import java.util.*;

public class P01LootBox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> firstLootBox = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(firstLootBox::offer);

        ArrayDeque<Integer> secondLootBox = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(secondLootBox::push);
        List<Integer> claimedItems = new ArrayList<>();
        while (!firstLootBox.isEmpty() && !secondLootBox.isEmpty()) {
            int sum = firstLootBox.peek() + secondLootBox.peek();
            if (sum % 2 == 0) {
                claimedItems.add(sum);
                firstLootBox.poll();
                secondLootBox.pop();
            } else {
                firstLootBox.offer(secondLootBox.pop());
            }
        }
        if (firstLootBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }
        int sumClaimedItems = claimedItems.stream().mapToInt(e -> e).sum();
        if (sumClaimedItems >= 100) {
            System.out.println("Your loot was epic! Value: " + sumClaimedItems);
        } else {
            System.out.println("Your loot was poor... Value: " + sumClaimedItems);
        }
    }
}
