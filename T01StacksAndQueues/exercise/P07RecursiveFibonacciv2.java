package T01StacksAndQueues.exercise;


import java.util.Scanner;

public class P07RecursiveFibonacciv2 {
    public static long[] memoryForFibonacci;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        memoryForFibonacci = new long[n + 1];

        System.out.println(fib(n));
    }

    private static long fib(int n) {
        if (n <= 1) {
            return 1;
        }
        if (memoryForFibonacci[n] != 0) {
            return memoryForFibonacci[n];//if it is already calculated
        }
        return memoryForFibonacci[n] = fib(n - 1) + fib(n - 2);
    }
}

