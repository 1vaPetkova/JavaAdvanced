package T09IteratorsAndComparators.exercise.P03StackIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        String input = "";
        while (!(input = scan.nextLine()).equals("END")) {
            String[] tokens = input.split("[, ]+");
            switch (tokens[0]) {
                case "Push":
                    Arrays.stream(input.split("[, ]+"))
                            .skip(1).mapToInt(Integer::parseInt)
                            .forEach(stack::push);
                    break;
                case "Pop":
                    stack.pop();
                    break;
            }
        }
        if (!stack.isEmpty()) {
            stack.print();
        }
    }
}

