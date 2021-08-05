package T05FunctionalProgramming.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10PredicateParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> guests = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = "";
        while (!(input = scan.nextLine()).equals("Party!")) {
            Predicate<String> filter = getPredicate(input);
            Function<String, List<String>> func = function(input, guests, filter);
            func.apply(input);
        }
        Consumer<List<String>> print = list -> {
            if (list.isEmpty()) {
                System.out.println("Nobody is going to the party!");
            } else {
                System.out.println(list.stream().sorted()
                        .collect(Collectors.joining(", ")) + " are going to the party!");
            }
        };
        print.accept(guests);

    }

    private static Function<String, List<String>> function(String input, List<String> guests, Predicate<String> filter) {
        return x -> {
            if (input.split("\\s+")[0].equals("Remove")) {
                guests.removeIf(filter);
                return guests;
            }
            List<String> toAmend = new ArrayList<>();
            guests.stream().filter(filter).forEach(toAmend::add);
            guests.addAll(toAmend);
            return guests;
        };

    }


    public static Predicate<String> getPredicate(String input) {
        String criteria = input.split("\\s+")[1];
        String text = input.split("\\s+")[2];
        switch (criteria) {
            case "StartsWith":
                return a -> a.startsWith(text);
            case "EndsWith":
                return a -> a.endsWith(text);
            case "Length":
                return a -> a.length() == Integer.parseInt(text);
        }
        return null;
    }
}