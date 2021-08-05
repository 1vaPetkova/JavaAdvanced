package T06DefiningClasses.exercise.P05CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int engineLines = Integer.parseInt(scan.nextLine());
        List<Engine> engines = new ArrayList<>();
        while (engineLines-- > 0) {
            //<Model> <Power> <Displacement> <Efficiency>
            String[] enginesInfo = scan.nextLine().split("\\s+");
            String engineModel = enginesInfo[0];
            int enginePower = Integer.parseInt(enginesInfo[1]);
            Engine engine = new Engine(engineModel, enginePower);
            if (enginesInfo.length == 3) {
                if (Character.isDigit(enginesInfo[2].charAt(0))) {
                    engine.setDisplacement(enginesInfo[2]);
                } else
                    engine.setEfficiency(enginesInfo[2]);
            } else if (enginesInfo.length == 4) {
                engine.setDisplacement(enginesInfo[2]);
                engine.setEfficiency(enginesInfo[3]);
            }
            engines.add(engine);
        }
        int carLines = Integer.parseInt(scan.nextLine());
        List<Car> cars = new ArrayList<>();
        while (carLines-- > 0) {
            //<Model> <Engine> <Weight> <Color>
            String[] carsInfo = scan.nextLine().split("\\s+");
            String carModel = carsInfo[0];
            String carEngine = carsInfo[1];
            Engine currentEngine = engines.stream()
                    .filter(e -> e.getEngineModel()
                            .equals(carEngine)).collect(Collectors.toList()).get(0);
            Car car = new Car(carModel, currentEngine);
            if (carsInfo.length == 3) {
                if (Character.isDigit(carsInfo[2].charAt(0))) {
                    car.setWeight(carsInfo[2]);
                } else
                    car.setColour(carsInfo[2]);
            } else if (carsInfo.length == 4) {
                car.setWeight(carsInfo[2]);
                car.setColour(carsInfo[3]);
            }
            cars.add(car);
        }
       cars.forEach(System.out::println);
    }
}
