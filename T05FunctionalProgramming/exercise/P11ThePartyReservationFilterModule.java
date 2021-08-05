package T05FunctionalProgramming.exercise;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P11ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> guests = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        HashMap<String, Predicate<String>> map = new HashMap<>();
        String input = "";
        while (!(input = scan.nextLine()).equals("Print")) {
            Predicate<String> filter = getPredicate(input);
            predicates(input, map, filter);
        }
        for (Map.Entry<String, Predicate<String>> entry : map.entrySet()) {
            Function<Predicate<String>, List<String>> func = x -> {
                guests.removeIf(entry.getValue());
                return guests;
            };
            func.apply(entry.getValue());
        }

        Consumer<List<String>> print = list -> System.out.print(String.join(" ",list));
        print.accept(guests);
    }


    private static void predicates
            (String input, HashMap<String, Predicate<String>> map, Predicate<String> filter) {
        String filterName = input.substring(input.indexOf(";") + 1);
        if (input.split(";")[0].equals("Add filter")) {
            map.putIfAbsent(filterName, filter);
        } else {
            map.remove(filterName);
        }
    }


    public static Predicate<String> getPredicate(String input) {
        String criteria = input.split(";")[1];
        String text = input.split(";")[2];
        switch (criteria) {
            case "Starts with":
                return a -> a.startsWith(text);
            case "Ends with":
                return a -> a.endsWith(text);
            case "Length":
                return a -> a.length() == Integer.parseInt(text);
            case "Contains":
                return a -> a.contains(text);
        }
        return null;
    }
}