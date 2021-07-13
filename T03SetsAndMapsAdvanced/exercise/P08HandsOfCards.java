package T03SetsAndMapsAdvanced.exercise;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class P08HandsOfCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, HashSet<String>> decks = new LinkedHashMap<>();
        String input = "";
        while (!(input = scan.nextLine()).equals("JOKER")) {
            String player = input.split(":")[0];
            String[] cards = input.split(":\\s+")[1].split(",\\s+");
            decks.putIfAbsent(player, new HashSet<>());
            decks.get(player).addAll(Arrays.asList(cards));

        }
        decks.forEach((key, value) -> {
            System.out.print(key + ": ");
            List<Integer> result = new ArrayList<>();
            value.forEach(c -> {
                String power = c.substring(0, c.length() - 1);
                String type = c.substring(c.length() - 1);
                result.add(powerValue(power) * typeValue(type));
            });
            System.out.print(result.stream().mapToInt(Integer::intValue).sum());
            System.out.println();
        });
    }

    private static int powerValue(String power) {
        int currentPower = 0;
        try {
            currentPower = Integer.parseInt(power);
        } catch (Exception E) {
            switch (power) {
                case "J":
                    currentPower = 11;
                    break;
                case "Q":
                    currentPower = 12;
                    break;
                case "K":
                    currentPower = 13;
                    break;
                case "A":
                    currentPower = 14;
                    break;
            }
        }
        return currentPower;
    }

    private static int typeValue(String type) {
        int currentType = 0;
        switch (type) {
            case "S":
                currentType = 4;
                break;
            case "H":
                currentType = 3;
                break;
            case "D":
                currentType = 2;
                break;
            case "C":
                currentType = 1;
                break;
        }
        return currentType;
    }
}
