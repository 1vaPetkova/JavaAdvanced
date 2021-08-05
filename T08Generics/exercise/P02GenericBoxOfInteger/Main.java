package T08Generics.exercise.P02GenericBoxOfInteger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Box<Integer> box = new Box<>();

        while (n-- > 0) {
            box.add(Integer.parseInt(scan.nextLine()));
        }
        System.out.println(box);
    }
}
