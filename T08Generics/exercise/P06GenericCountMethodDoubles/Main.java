package T08Generics.exercise.P06GenericCountMethodDoubles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Box<Double> box = new Box<>();

        while (n-- > 0) {
            box.add(Double.parseDouble(scan.nextLine()));
        }
        Double element = Double.parseDouble(scan.nextLine());
        System.out.println(box.countGreaterElements(element));
    }
}
