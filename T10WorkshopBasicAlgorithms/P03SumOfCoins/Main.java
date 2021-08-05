package T10WorkshopBasicAlgorithms.P03SumOfCoins;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(7).split(", ");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(in.nextLine().substring(5));

        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);

        List<Integer> amounts = new ArrayList<>();
        usedCoins.forEach((k, v) -> amounts.add(k * v));

        int totalAmount = amounts.stream().mapToInt(e -> e).sum();
        if (targetSum > totalAmount) {
            System.out.println("Error");
        } else {
            int sumCoins = usedCoins.values().stream().mapToInt(i -> i).sum();
            System.out.println("Number of coins to take: " + sumCoins);
            usedCoins.forEach((k, v) -> System.out.printf("%d coin(s) with value %d\n", v, k));
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        Map<Integer, Integer> result = new LinkedHashMap<>();
        coins = Arrays.stream(coins).boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(i -> i).toArray();
        for (Integer coin : coins) {
            int coinsToTake = targetSum / coin;
            if (coinsToTake != 0) {
                result.put(coin, coinsToTake);
                targetSum = targetSum % coin;
            }
            if (targetSum == 0) {
                break;
            }
        }
        return result;
    }
}