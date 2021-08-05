package T06DefiningClasses.exercise.P05CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private String weight;
    private String colour;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = "n/a";
        this.colour = "n/a";
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getWeight() {
        return weight;
    }

    public String getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return String.format("%s:\n" +
                        "%s:\n" +
                        "Power: %d\n" +
                        "Displacement: %s\n" +
                        "Efficiency: %s\n" +
                        "Weight: %s\n" +
                        "Color: %s", getModel(),
                getEngine().getEngineModel(), getEngine().getPower(),
                getEngine().getDisplacement(), getEngine().getEfficiency(),
                getWeight(), getColour());
    }
}
