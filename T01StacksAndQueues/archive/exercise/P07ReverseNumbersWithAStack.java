package T01StacksAndQueues.archive.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P07ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        list.forEach(stack::push);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
