package T03SetsAndMapsAdvanced.exercise;

import java.util.*;

public class P14DragonArmy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputs = Integer.parseInt(scan.nextLine());
        LinkedHashMap<String, TreeMap<String, int[]>> map = new LinkedHashMap<>();
        for (int i = 0; i < inputs; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String type = tokens[0];
            String name = tokens[1];
            int[] stats = new int[3];
            stats[0] = !tokens[2].equals("null") ? Integer.parseInt(tokens[2]) : 45;//damage
            stats[1] = !tokens[3].equals("null") ? Integer.parseInt(tokens[3]) : 250;//health
            stats[2] = !tokens[4].equals("null") ? Integer.parseInt(tokens[4]) : 10;//armor

            map.putIfAbsent(type, new TreeMap<>());
            map.get(type).putIfAbsent(name, new int[3]);
            map.get(type).put(name, stats);
        }
        map.forEach((key1, value1) -> {
            List<Integer> sumDamage = new ArrayList<>();
            List<Integer> sumHealth = new ArrayList<>();
            List<Integer> sumArmor = new ArrayList<>();
            value1.forEach((key, value) -> {
                sumDamage.add(value[0]);
                sumHealth.add(value[1]);
                sumArmor.add(value[2]);
            });
            double avgDamage = 1.0 * (sumDamage.stream().mapToInt(Integer::intValue).sum()) / sumDamage.size();
            double avgHealth = 1.0 * (sumHealth.stream().mapToInt(Integer::intValue).sum()) / sumHealth.size();
            double avgArmor = 1.0 * (sumArmor.stream().mapToInt(Integer::intValue).sum()) / sumArmor.size();
            System.out.printf("%s::(%.2f/%.2f/%.2f)\n", key1, avgDamage, avgHealth, avgArmor);
            value1.forEach((key, value) ->
                    System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n", key, value[0], value[1], value[2]));
        });
    }
}
