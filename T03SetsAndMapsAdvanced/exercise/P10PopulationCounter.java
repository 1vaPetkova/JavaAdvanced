package T03SetsAndMapsAdvanced.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P10PopulationCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        LinkedHashMap<String, LinkedHashMap<String, Long>> map = new LinkedHashMap<>();
        while (!(input = scan.nextLine()).equals("report")) {
            String[] tokens = input.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);
            map.putIfAbsent(country, new LinkedHashMap<>());
            map.get(country).put(city, population);

        }

        map.entrySet().stream().sorted((f, s) -> {
            long sSum = s.getValue().values().stream().mapToLong(Long::longValue).sum();
            long fSum = f.getValue().values().stream().mapToLong(Long::longValue).sum();
            return Long.compare(sSum, fSum);
        }).forEach(e -> {
            long sum = e.getValue().values().stream().mapToLong(Long::longValue).sum();
            System.out.printf("%s (total population: %d)\n", e.getKey(), sum);
            e.getValue().entrySet().stream().sorted((f, s) -> Long.compare(s.getValue(), f.getValue()))
                    .forEach(city -> System.out.printf("=>%s: %d\n", city.getKey(), city.getValue()));
        });
    }
}
