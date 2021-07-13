package T03SetsAndMapsAdvanced.exercise;

import java.util.*;

public class P12LegendaryFarming {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TreeMap<String, Integer> materials = new TreeMap<>();
        materials.put("shards", 0);
        materials.put("fragments", 0);
        materials.put("motes", 0);

        TreeMap<String, Integer> junk = new TreeMap<>();

        int currentQty = 0;
        String currMaterial = "";
        boolean isObtained = false;
        while (!isObtained) {
            String[] input = scan.nextLine().split("\\s+");
            for (int i = 0; i < input.length; i++) {
                if (i % 2 == 0) {
                    currentQty = Integer.parseInt(input[i]);
                } else {
                    currMaterial = input[i].toLowerCase(Locale.ROOT);
                    if (isKeyMaterial(currMaterial)) {
                        materials.put(currMaterial, materials.get(currMaterial) + currentQty);
                        if (materials.get(currMaterial) >= 250) {
                            materials.put(currMaterial, materials.get(currMaterial) - 250);
                            System.out.printf("%s obtained!\n", item(currMaterial));
                            isObtained = true;
                            break;
                        }
                    } else {
                        junk.putIfAbsent(currMaterial, 0);
                        junk.put(currMaterial, junk.get(currMaterial) + currentQty);
                    }
                }
            }
        }
        materials.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(e -> System.out.printf("%s: %d\n", e.getKey(), e.getValue()));
        junk.forEach((k, v) -> System.out.printf("%s: %d\n", k, v));
    }

    private static String item(String currMaterial) {
        switch (currMaterial) {
            case "shards":
                return "Shadowmourne";
            case "fragments":
                return "Valanyr";
            case "motes":
                return "Dragonwrath";
        }
        return "";
    }

    private static boolean isKeyMaterial(String currMaterial) {
        switch (currMaterial) {
            case "shards":
            case "fragments":
            case "motes":
                return true;
        }
        return false;
    }
}
