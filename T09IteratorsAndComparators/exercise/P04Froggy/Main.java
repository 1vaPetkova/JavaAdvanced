package T09IteratorsAndComparators.exercise.P04Froggy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] stones = Arrays.stream(scan.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Lake lake = new Lake(stones);
        StringBuilder sb = new StringBuilder();
        for (Integer integer : lake) {
            sb.append(integer).append(", ");
        }
        System.out.println(sb.substring(0,sb.length()-2));
    }
}
