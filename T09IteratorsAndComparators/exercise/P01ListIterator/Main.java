package T09IteratorsAndComparators.exercise.P01ListIterator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> list = Arrays.stream(scan.nextLine().split("\\s+"))
                .skip(1).collect(Collectors.toList());
        String input = "";
        ListyIterator iterator = new ListyIterator(list);
        while (!(input = scan.nextLine()).equals("END")) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Move":
                    System.out.println(iterator.move());
                    break;
                case "Print":
                    iterator.print();
                    break;
                case "HasNext":
                    System.out.println(iterator.hasNext());
                    break;
            }
        }
    }
}
