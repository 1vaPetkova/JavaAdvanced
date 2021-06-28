package T01StacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P03DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int decimal = Integer.parseInt(scan.nextLine());
        ArrayDeque<Integer> binary = new ArrayDeque<>();

        while (decimal > 0) {
            binary.push(decimal % 2);
            decimal /= 2;
        }
        if (binary.isEmpty()) {
            System.out.println(0);
        } else {
            for (Integer integer : binary) {
                System.out.print(binary.pop());
            }
        }

    }
}
