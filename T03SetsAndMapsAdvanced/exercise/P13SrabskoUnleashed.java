package T03SetsAndMapsAdvanced.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P13SrabskoUnleashed {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Integer>> map = new LinkedHashMap<>();
        String input = "";
        Pattern pattern = Pattern.compile("(?<singer>[A-Za-z\\s]+)\\s" +
                "@(?<venue>[A-Za-z\\s]+)\\s" +
                "(?<price>\\d+)\\s" +
                "(?<tickets>\\d+)");
        while (!(input = scan.nextLine()).equals("End")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String venue = matcher.group("venue");
                String singer = matcher.group("singer");
                int price = Integer.parseInt(matcher.group("price"));
                int tickets = Integer.parseInt(matcher.group("tickets"));
                map.putIfAbsent(venue, new LinkedHashMap<>());
                map.get(venue).putIfAbsent(singer, 0);
                map.get(venue).put(singer, map.get(venue).get(singer) + price * tickets);
            }
        }
        map.forEach((key, value) -> {
            System.out.println(key);
            value.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach(s -> System.out.printf("#  %s -> %d\n", s.getKey(), s.getValue()));
        });
    }
}
