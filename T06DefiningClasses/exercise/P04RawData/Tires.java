package T06DefiningClasses.exercise.P04RawData;

import java.util.ArrayList;
import java.util.List;

public class Tires {
    private double tire1Pressure;
    private double tire1Age;
    private double tire2Pressure;
    private double tire2Age;
    private double tire3Pressure;
    private double tire3Age;
    private double tire4Pressure;
    private double tire4Age;

    public Tires(double tire1Pressure, double tire1Age,
                 double tire2Pressure, double tire2Age,
                 double tire3Pressure, double tire3Age,
                 double tire4Pressure, double tire4Age) {
        this.tire1Pressure = tire1Pressure;
        this.tire1Age = tire1Age;
        this.tire2Pressure = tire2Pressure;
        this.tire2Age = tire2Age;
        this.tire3Pressure = tire3Pressure;
        this.tire3Age = tire3Age;
        this.tire4Pressure = tire4Pressure;
        this.tire4Age = tire4Age;
    }

    public double getMinTirePressure(double tire1Pressure, double tire2Pressure, double tire3Pressure, double tire4Pressure) {
        List<Double> pressures = new ArrayList<>();
        pressures.add(tire1Pressure);
        pressures.add(tire2Pressure);
        pressures.add(tire3Pressure);
        pressures.add(tire4Pressure);
        return pressures.stream().mapToDouble(e -> e).min().orElse(0.0);
    }

    public double getTire1Pressure() {
        return tire1Pressure;
    }

    public double getTire2Pressure() {
        return tire2Pressure;
    }

    public double getTire3Pressure() {
        return tire3Pressure;
    }

    public double getTire4Pressure() {
        return tire4Pressure;
    }
}
