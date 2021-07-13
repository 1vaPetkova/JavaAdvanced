package T03SetsAndMapsAdvanced.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P09UserLogs {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TreeMap<String, LinkedHashMap<String, Integer>> map = new TreeMap<>();

        String input = "";
        while (!(input = scan.nextLine()).equals("end")) {
            String[] tokens = input.split("\\s+");
            Pattern ipPattern = Pattern.compile("([A-Z]+=)(?<ip>(.*))");
            Matcher ipMatcher = ipPattern.matcher(tokens[0]);
            String ipAddress = "";

            if (ipMatcher.find()) {
                ipAddress = ipMatcher.group("ip");
            }
            Pattern userPattern = Pattern.compile("([a-z]+)=(?<user>(.*))");
            Matcher userMatcher = userPattern.matcher(tokens[2]);
            String username = "";
            if (userMatcher.find()) {
                username = userMatcher.group("user");
            }
            map.putIfAbsent(username, new LinkedHashMap<>());
            map.get(username).putIfAbsent(ipAddress, 0);
            map.get(username).put(ipAddress, map.get(username).get(ipAddress) + 1);

        }
        map.forEach((k, v) -> {
            System.out.println(k + ": ");
            StringBuilder output = new StringBuilder();
            for (Map.Entry<String, Integer> entry : v.entrySet()) {
                output.append(String.format("%s => %d, ", entry.getKey(), entry.getValue()));
            }
                System.out.println(output.substring(0, output.length() - 2) + ".");
        });
    }
}
