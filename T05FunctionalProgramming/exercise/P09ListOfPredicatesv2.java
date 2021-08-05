package T05FunctionalProgramming.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P09ListOfPredicatesv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Predicate<Integer> isDivisible = v -> {
            for (Integer integer : numbers) {
                if (v % integer != 0) {
                    return false;
                }
            }
            return true;
        };

        IntStream.rangeClosed(1, n).filter(isDivisible::test).forEach(e -> System.out.print(e + " "));
    }
}
