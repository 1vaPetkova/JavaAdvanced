package T05FunctionalProgramming.exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P08CustomComparator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Comparator<Integer> comparator = ((f, s) -> {
            if (f % 2 != 0 && s % 2 == 0) {
                return 1;
            } else if (f % 2 == 0 && s % 2 != 0) {
                return -1;
            }
            return f.compareTo(s);
        });
        numbers.stream().sorted(comparator).forEach(e -> System.out.print(e + " "));

    }
}
