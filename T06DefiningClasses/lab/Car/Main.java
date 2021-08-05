package T06DefiningClasses.lab.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());

        List<Car> cars = new ArrayList<>();
        while (lines-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");
            Car car;
            if (tokens.length == 1) {
                car = new Car(tokens[0]);
            } else if (tokens.length > 2) {
                car = new Car(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
            } else {
                car = new Car(tokens[0], tokens[1]);
            }
            cars.add(car);
        }
        cars.forEach(System.out::print);
    }
}
