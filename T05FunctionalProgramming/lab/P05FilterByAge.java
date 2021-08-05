package T05FunctionalProgramming.lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class P05FilterByAge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] tokens = scan.nextLine().split(", ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            people.put(name, age);
        }

        String ageCriteria = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());
        String format = scan.nextLine();


        people.entrySet().stream().filter(getAgeFilter(age, ageCriteria))
                .forEach(getFormatter(format));
    }

    private static Consumer<Map.Entry<String, Integer>> getFormatter(String format) {
        if (format.equals("name")) {
          return  entry -> System.out.println(entry.getKey());
        } else if (format.equals("age")) {
           return entry -> System.out.println(entry.getValue());
        }
          return   entry -> System.out.println(entry.getKey() + " - " + entry.getValue());
           }


    private static Predicate<Map.Entry<String, Integer>> getAgeFilter(int age, String criteria) {
        if (criteria.equals("older")) {
            return e -> e.getValue() >= age;
        }
        return e -> e.getValue() <= age;
    }
}
