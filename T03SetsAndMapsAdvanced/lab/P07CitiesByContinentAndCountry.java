package T03SetsAndMapsAdvanced.lab;

import java.util.*;

public class P07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        LinkedHashMap<String, LinkedHashMap<String, List<String>>> info = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];
            info.putIfAbsent(continent, new LinkedHashMap<>());
            LinkedHashMap<String, List<String>> innerMap = info.get(continent);
            innerMap.putIfAbsent(country, new ArrayList<>());
            innerMap.get(country).add(city);
        }
        info.forEach((k, v) -> {
            System.out.println(k + ":");
            v.forEach((key, value) -> System.out.println("  " + key + " -> " + String.join(", ", value)));
        });

    }
}
