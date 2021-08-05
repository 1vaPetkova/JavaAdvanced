package T05FunctionalProgramming.lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .toArray();

        Function<IntStream,String> formatNumbers = str->str
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        String evenNumbers = formatNumbers.apply(Arrays.stream(numbers));
        String sortedOutput = formatNumbers.apply(Arrays.stream(numbers).sorted());

        System.out.println(evenNumbers);
        System.out.println(sortedOutput);
    }


}

