package T03SetsAndMapsAdvanced.exercise;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class P06aMinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        String resource = "";
        while (!(resource = scan.nextLine()).equals("stop")) {
            int quantity = Integer.parseInt(scan.nextLine());
            map.putIfAbsent(resource, 0);
            map.put(resource, map.get(resource) + quantity);
        }
        map.forEach((k, v) -> System.out.printf("%s -> %d\n", k, v));
    }
}
