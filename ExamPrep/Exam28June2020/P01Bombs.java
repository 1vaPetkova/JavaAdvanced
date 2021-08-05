package ExamPrep.Exam28June2020;

import java.util.*;
import java.util.stream.Collectors;

public class P01Bombs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> bombEffects = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(bombEffects::offer);

        ArrayDeque<Integer> bombCasing = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(bombCasing::push);

        Map<Integer, String> bombMaterials = new TreeMap<>();
        bombMaterials.put(40, "Datura Bombs");
        bombMaterials.put(60, "Cherry Bombs");
        bombMaterials.put(120, "Smoke Decoy Bombs");

        Map<String, Integer> bombs = new TreeMap<>();
        bombs.put("Datura Bombs", 0);
        bombs.put("Cherry Bombs", 0);
        bombs.put("Smoke Decoy Bombs", 0);
        boolean isBombPouchFilled = false;
        while (!bombEffects.isEmpty() && !bombCasing.isEmpty()) {
            int sumValues = bombEffects.peek() + bombCasing.peek();
            if (bombMaterials.entrySet().stream().anyMatch(e -> e.getKey() == sumValues)) {
                String bombCreated = bombMaterials.get(sumValues);
                bombs.put(bombCreated, bombs.get(bombCreated) + 1);
                bombEffects.poll();
                bombCasing.pop();
            } else {
                int newBombCasingValue = bombCasing.pop() - 5;
                bombCasing.push(newBombCasingValue);
            }
            if (bombs.get("Datura Bombs") >= 3 && bombs.get("Cherry Bombs") >= 3 && bombs.get("Smoke Decoy Bombs") >= 3) {
                isBombPouchFilled = true;
                break;
            }
        }
        if (isBombPouchFilled) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (bombEffects.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.println("Bomb Effects: " +
                    bombEffects.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (bombCasing.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.println("Bomb Casings: "
                    + bombCasing.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        bombs.forEach((k, v) -> System.out.println(k + ": " + v));

    }

}
