package T06DefiningClasses.exercise.P04RawData;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());

        LinkedHashMap<String, Car> map = new LinkedHashMap<>();
        while (lines-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");
            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            double tire1Pressure = Double.parseDouble(tokens[5]);
            double tire1Age = Double.parseDouble(tokens[6]);
            double tire2Pressure = Double.parseDouble(tokens[7]);
            double tire2Age = Double.parseDouble(tokens[8]);
            double tire3Pressure = Double.parseDouble(tokens[9]);
            double tire3Age = Double.parseDouble(tokens[10]);
            double tire4Pressure = Double.parseDouble(tokens[11]);
            double tire4Age = Double.parseDouble(tokens[12]);
            map.putIfAbsent(model, new Car(model,
                    new Engine(engineSpeed, enginePower),
                    new Cargo(cargoWeight, cargoType),
                    new Tires(tire1Pressure, tire1Age, tire2Pressure, tire2Age,
                            tire3Pressure, tire3Age, tire4Pressure, tire4Age)));
        }
        String command = scan.nextLine();
        switch (command) {
            case "fragile":
                map.entrySet().stream().filter(c -> c.getValue().getCargo().getCargoType().equals(command))
                        .filter(c -> c.getValue().getTires().getMinTirePressure(c.getValue().getTires().getTire1Pressure(),
                                c.getValue().getTires().getTire2Pressure(),
                                c.getValue().getTires().getTire3Pressure(),
                                c.getValue().getTires().getTire4Pressure()) < 1)
                        .forEach(m -> System.out.println(m.getKey()));
                break;
            case "flamable":
                map.entrySet().stream().filter(c -> c.getValue().getCargo().getCargoType().equals(command))
                        .filter(c -> c.getValue().getEngine().getEnginePower() > 250)
                        .forEach(m -> System.out.println(m.getKey()));
                break;
        }
    }
}
