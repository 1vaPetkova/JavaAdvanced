package T01StacksAndQueues.exercise;

import java.util.*;

public class P10PoisonousPlants {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] plants = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] days = new int[n];
        ArrayDeque<Integer> prevPlantsIndex = new ArrayDeque<>();
        prevPlantsIndex.push(0);
        for (int i = 1; i < plants.length; i++) {
            int maxDays = 0;
            while (!prevPlantsIndex.isEmpty() && plants[prevPlantsIndex.peek()] >= plants[i]) {
                maxDays = Math.max(maxDays, days[prevPlantsIndex.pop()]);
            }
            if (!prevPlantsIndex.isEmpty()) {
                days[i] = maxDays + 1;
            }
            prevPlantsIndex.push(i);
        }
        System.out.println(Arrays.stream(days).max().getAsInt());
    }
}
