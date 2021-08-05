package T06DefiningClasses.exercise.P03SpeedRacing;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());
        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();
        while (lines-- > 0) {
            //"<Model> <FuelAmount> <FuelCostFor1km>"
            String[] tokens = scan.nextLine().split("\\s+");
            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelCostPerKm = Double.parseDouble(tokens[2]);
            cars.putIfAbsent(model, new Car(model, fuelAmount, fuelCostPerKm));
        }

        String input = "";
        while (!(input = scan.nextLine()).equals("End")) {
            String[] commands = input.split("\\s+");
            //"Drive <CarModel>  <amountOfKm>"
            String carModel = commands[1];
            double distance = Double.parseDouble(commands[2]);
            if (cars.get(carModel).isFuelEnough(distance)) {
                cars.get(carModel).reduceFuel(distance);
                cars.get(carModel).setDistanceTravelled(distance);
            } else {
                System.out.println("Insufficient fuel for the drive");
            }
        }
        cars.forEach((key, value) -> System.out.printf("%s %.2f %.0f\n",
                value.getModel(), value.getFuel(), value.getDistanceTravelled()));
    }
}
