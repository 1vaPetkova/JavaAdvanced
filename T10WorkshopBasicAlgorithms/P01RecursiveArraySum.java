package T10WorkshopBasicAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class P01RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = sumArr(arr, 0);
        System.out.println(sum);
    }

    private static int sumArr(int[] arr, int index) {
        if (index == arr.length) {
            return 0;
        }
        return sumArr(arr, index + 1) + arr[index];
    }
}
