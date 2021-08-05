package T05FunctionalProgramming.exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class P03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Function<int[], Integer> min = v -> Arrays.stream(v).min().orElse(0);

        Consumer<Integer> result = System.out::println;
        result.accept(min.apply(arr));
    }
}
