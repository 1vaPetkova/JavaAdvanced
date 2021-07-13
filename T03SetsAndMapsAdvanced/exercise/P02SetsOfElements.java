package T03SetsAndMapsAdvanced.exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int firstSetLength = Integer.parseInt(input.split("\\s+")[0]);
        int secondSetLength = Integer.parseInt(input.split("\\s+")[1]);
        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < firstSetLength; i++) {
            firstSet.add(Integer.parseInt(scan.nextLine()));
        }
        for (int i = 0; i < secondSetLength; i++) {
            secondSet.add(Integer.parseInt(scan.nextLine()));
        }

        firstSet.retainAll(secondSet);//leaves only the dublicated elements in the first set
        firstSet.forEach(e -> System.out.print(e + " "));

    }
}
