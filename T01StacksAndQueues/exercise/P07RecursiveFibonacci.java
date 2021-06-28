package T01StacksAndQueues.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        if (n <= 0) {
            System.out.println(0);
        } else if (n == 1) {
            System.out.println(1);
        } else {
            ArrayDeque<Long> stack = new ArrayDeque<>();
            long sum = 0;
            for (int i = 0; i <= n; i++) {
                if(i<2){
                    stack.push(1L);
                    sum+=stack.peek();
                } else{
                    long current = stack.peek();
                    stack.push(sum);
                    sum=stack.peek()+current;
                }
            }
            System.out.println(stack.peek());
        }
    }
}

