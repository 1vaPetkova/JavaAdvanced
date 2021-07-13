package T03SetsAndMapsAdvanced.exercise;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Scanner;

public class P07FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        String name = "";
        while (!(name = scan.nextLine()).equals("stop")) {
            String email = scan.nextLine();
            if (isValid(email)) {
                map.put(name, email);
            }
        }
        map.forEach((key, value) -> System.out.printf("%s -> %s\n", key, value));
    }

    private static boolean isValid(String s) {
        return !s.toLowerCase(Locale.ROOT).endsWith("uk")
                && !s.toLowerCase(Locale.ROOT).endsWith("us")
                && !s.toLowerCase(Locale.ROOT).endsWith("com");
    }
}
