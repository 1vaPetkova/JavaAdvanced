package T03SetsAndMapsAdvanced.exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TreeSet<String> elements = new TreeSet<>();
        int compounds = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < compounds; i++) {
            elements.addAll(Arrays.asList(scan.nextLine().split("\\s+")));
        }
        System.out.println(String.join(" ",elements));
    }
}
