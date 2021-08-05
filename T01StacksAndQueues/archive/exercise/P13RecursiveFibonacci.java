package T01StacksAndQueues.archive.exercise;

import java.util.Scanner;

public class P13RecursiveFibonacci {
    private static long[] elements;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        elements = new long[number + 1];
        System.out.println(fib(number));
    }

    private static long fib(int number) {
        if (number == 0 || number == 1) {
            return 1;
        }
        if (elements[number] != 0) {
            return elements[number];
        }
        return elements[number] = fib(number - 2) + fib(number - 1);
    }
}
