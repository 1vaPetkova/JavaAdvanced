package T05FunctionalProgramming.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P09ListOfPredicates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        BiFunction<List<Integer>, Integer, Boolean> predicate = ((list, number) -> {
            for (Integer integer : list) {
                if (number % integer != 0) {
                    return false;
                }
            }
            return true;
        });

        for (int i = 1; i <= n; i++) {
            if (predicate.apply(numbers, i)) {
                System.out.print(i + " ");
            }
        }
    }
}
