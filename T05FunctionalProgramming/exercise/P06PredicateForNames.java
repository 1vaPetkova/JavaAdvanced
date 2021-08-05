package T05FunctionalProgramming.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P06PredicateForNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = Integer.parseInt(scan.nextLine());

        Predicate<String> isShorter = name -> name.length() <= length;
        List<String> names = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        names.stream().filter(isShorter).forEach(System.out::println);
    }
}
