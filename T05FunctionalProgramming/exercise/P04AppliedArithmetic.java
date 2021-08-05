package T05FunctionalProgramming.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P04AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Function<int[], int[]> add = n -> Arrays.stream(n).map(v -> v + 1).toArray();
        Function<int[], int[]> multiply = n -> Arrays.stream(n).map(v -> v * 2).toArray();
        Function<int[], int[]> subtract = n -> Arrays.stream(n).map(v -> v - 1).toArray();
        Consumer<Integer> print = n -> System.out.print(n + " ");

        String input = "";
        while (!(input = scan.nextLine()).equals("end")) {
            switch (input) {
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case "print":
                    Arrays.stream(numbers).forEach(print::accept);
                    System.out.println();
                    break;
            }
        }
    }
}
