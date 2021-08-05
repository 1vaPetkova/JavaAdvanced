package T08Generics.exercise.P03GenericSwapMethodStrings;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Box<String> box = new Box<>();

        while (n-- > 0) {
            box.add(scan.nextLine());
        }
        int firstIndex = scan.nextInt();
        int secondIndex = scan.nextInt();
        box.swap(firstIndex,secondIndex);
        System.out.println(box);
    }
}
