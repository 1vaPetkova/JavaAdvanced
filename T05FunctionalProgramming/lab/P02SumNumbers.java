package T05FunctionalProgramming.lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class P02SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tokens = scan.nextLine().split(",\\s+");
        Function<String[], Stream<Integer>> map = arr -> Arrays.stream(arr).map(Integer::parseInt);

        Function<Stream<Integer>, Integer> sum = str -> str.mapToInt(e -> e).sum();
        Function<Stream<Integer>, Long> count = str -> str.mapToInt(e -> e).count();


        Consumer<Long> printCountConsumer = num -> System.out.println("Count = " + count.apply(map.apply(tokens)));
        Consumer<Integer> printSumConsumer = num -> System.out.println("Sum = " + sum.apply(map.apply(tokens)));

        printCountConsumer.accept(count.apply(map.apply(tokens)));
        printSumConsumer.accept(sum.apply(map.apply(tokens)));


    }
}
