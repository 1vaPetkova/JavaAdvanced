package T03SetsAndMapsAdvanced.exercise;

import java.util.*;

public class P11LogsAggregator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputs = Integer.parseInt(scan.nextLine());
        TreeMap<String, Integer> time = new TreeMap<>();
        TreeMap<String, TreeSet<String>> ip = new TreeMap<>();
        while (inputs-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");
            String ipAddress = tokens[0];
            String user = tokens[1];
            int duration = Integer.parseInt(tokens[2]);
            time.putIfAbsent(user, 0);
            time.put(user, time.get(user) + duration);
            ip.putIfAbsent(user, new TreeSet<>());
            ip.get(user).add(ipAddress);
        }
        time.forEach((k, v) -> System.out.printf("%s: %d %s\n", k, v, ip.get(k)));
    }
}
