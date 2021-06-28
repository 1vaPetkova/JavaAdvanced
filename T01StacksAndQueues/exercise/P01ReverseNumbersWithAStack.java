package T01StacksAndQueues.exercise;

import java.util.*;
import java.util.stream.Collectors;

public class P01ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> list = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        ArrayDeque<String> stack = new ArrayDeque<>();
        list.forEach(stack::push);

        System.out.println(String.join(" ", stack));
    }
}
