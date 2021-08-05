package T10WorkshopBasicAlgorithms;

import java.util.Scanner;

public class P02RecursiveFactorial {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        long fact = fact(n);
        System.out.println(fact);
    }

    private static long fact(int n) {
        if (n == 0) {
            return 1;
        }
        return n * fact(n - 1);
    }
}
