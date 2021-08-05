package T06DefiningClasses.exercise.P05CarSalesman;

public class Engine {
    private String engineModel;
    private int power;
    private String displacement;
    private String efficiency;

    public Engine(String engineModel, int power) {
        this.engineModel = engineModel;
        this.power = power;
        this.displacement = "n/a";
        this.efficiency = "n/a";
    }

    public String getEngineModel() {
        return engineModel;
    }

    public int getPower() {
        return power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }
}
