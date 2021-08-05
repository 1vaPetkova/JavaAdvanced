package T09IteratorsAndComparators.exercise.P02Collection;

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
        ListyIterator listyIterator = new ListyIterator(list);
        while (!(input = scan.nextLine()).equals("END")) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    listyIterator.print();
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "PrintAll":
                    listyIterator.printAll();
                    break;
            }
        }
    }
}
