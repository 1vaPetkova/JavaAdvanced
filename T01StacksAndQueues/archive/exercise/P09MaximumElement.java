package T01StacksAndQueues.archive.exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P09MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int lines = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < lines; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            switch (Integer.parseInt(tokens[0])){
                case 1:
                    stack.push(Integer.parseInt(tokens[1]));
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    if(!stack.isEmpty()){
                    System.out.println(Collections.max(stack));
                    }
                    break;
            }
        }
    }
}
