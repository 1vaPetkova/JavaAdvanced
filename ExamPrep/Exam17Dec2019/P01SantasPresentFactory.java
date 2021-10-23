package ExamPrep.Exam17Dec2019;

import java.util.*;
import java.util.stream.Collectors;

public class P01SantasPresentFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> materials = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(materials::push);

        ArrayDeque<Integer> magicLevels = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(magicLevels::offer);

        Map<Integer, String> levelsNeeded = new LinkedHashMap<>();
        levelsNeeded.put(150, "Doll");
        levelsNeeded.put(250, "Wooden train");
        levelsNeeded.put(300, "Teddy bear");
        levelsNeeded.put(400, "Bicycle");

        Map<String, Integer> toys = new TreeMap<>();
        toys.put("Doll", 0);
        toys.put("Wooden train", 0);
        toys.put("Teddy bear", 0);
        toys.put("Bicycle", 0);

        while (!materials.isEmpty() && !magicLevels.isEmpty()) {
            int currentMaterial = materials.peek();
            int currentMagicLevel = magicLevels.peek();
            int total = currentMaterial * currentMagicLevel;
            if (levelsNeeded.entrySet().stream().anyMatch(e -> total == e.getKey())) {
                String toyProduced = levelsNeeded.get(total);
                toys.put(toyProduced, toys.get(toyProduced) + 1);
                materials.pop();
                magicLevels.poll();
            } else {
                int sum = currentMaterial + currentMagicLevel;
                if (total < 0) {
                    materials.pop();
                    magicLevels.poll();
                    materials.push(sum);
                } else if (total > 0) {
                    magicLevels.poll();
                    materials.push(materials.pop() + 15);
                } else {
                    if (currentMaterial == 0) {
                        materials.pop();
                    }
                    if (currentMagicLevel == 0) {
                        magicLevels.poll();
                    }
                }
            }
        }
        if ((toys.get("Teddy bear") > 0 && toys.get("Bicycle") > 0)
                || (toys.get("Doll") > 0 && toys.get("Wooden train") > 0)) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }
        if (!materials.isEmpty()) {
            System.out.print("Materials left: ");
            System.out.println(materials.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        if (!magicLevels.isEmpty()) {
            System.out.print("Magic left: ");
            System.out.println(magicLevels.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        toys.entrySet().stream()
                .filter(e -> e.getValue() > 0)
                .forEach(e -> System.out.printf("%s: %d\n", e.getKey(), e.getValue()));
    }
}
