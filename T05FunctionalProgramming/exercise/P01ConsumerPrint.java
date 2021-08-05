package T05FunctionalProgramming.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class P01ConsumerPrint {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> list = Arrays.stream(scan.nextLine().split("\\s+"))
                            .collect(Collectors.toList());
        Consumer<String> output = System.out::println;
        list.forEach(output);
    }
}
