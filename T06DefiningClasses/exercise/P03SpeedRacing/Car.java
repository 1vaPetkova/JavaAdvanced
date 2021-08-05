package T06DefiningClasses.exercise.P03SpeedRacing;

public class Car {
    private String model;
    private double fuel;
    private double fuelCostPerKm;
    private double distanceTravelled;

    public Car(String model, double fuel, double fuelCostPerKm) {
        this.model = model;
        this.fuel = fuel;
        this.fuelCostPerKm = fuelCostPerKm;
        this.distanceTravelled = 0;
    }

    public String getModel() {
        return model;
    }

    public double getFuel() {
        return fuel;
    }

    public double getDistanceTravelled() {
        return distanceTravelled;
    }


    public boolean isFuelEnough(double distance) {
        return this.fuel - this.fuelCostPerKm * distance >= 0;
    }

    public double reduceFuel(double distance) {
        return this.fuel -= this.fuelCostPerKm * distance;
    }

    public void setDistanceTravelled(double distance) {
        this.distanceTravelled += distance;
    }
}
