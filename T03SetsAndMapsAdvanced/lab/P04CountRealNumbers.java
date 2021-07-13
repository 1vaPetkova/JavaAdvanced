package T03SetsAndMapsAdvanced.lab;

import java.util.*;
import java.util.stream.Collectors;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<Double, Integer> count = new LinkedHashMap<>();
        List<Double> input = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        input.forEach(e -> {
            count.putIfAbsent(e, 0);
            count.put(e, count.get(e) + 1);
        });
        count.forEach((key, value) -> System.out.println(String.format("%.1f", key) + " -> " + value));
    }
}
