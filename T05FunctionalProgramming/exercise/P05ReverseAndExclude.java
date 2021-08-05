package T05FunctionalProgramming.exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int divider = Integer.parseInt(scan.nextLine());
        Predicate<Integer> isDivisible = n -> n % divider == 0;
        Collections.reverse(numbers);
        numbers.removeIf(isDivisible);
        numbers.forEach(a -> System.out.print(a + " "));




    }
}
