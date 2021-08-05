package T05FunctionalProgramming.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P01SortEvenNumbersv2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
                List<Integer> nums = Arrays.stream(scan.nextLine().split(",\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                nums.removeIf(n->n%2!=0);


        String evenNumbers = nums.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        nums.sort(Integer::compareTo);

        String sortedOutput = nums.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(evenNumbers);
        System.out.println(sortedOutput);
    }


}

