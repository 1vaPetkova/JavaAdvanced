package T06DefiningClasses.exercise.P07Google;

public class Car {

    private String carModel;
    private int carSpeed;

    public Car(){
    }
    public Car(String carModel, int carSpeed) {
        this.carModel = carModel;
        this.carSpeed = carSpeed;
    }

    public String getCarModel() {
        return carModel;
    }

    public int getCarSpeed() {
        return carSpeed;
    }

    @Override
    public String toString() {
        return String.format("%s %d", getCarModel(), getCarSpeed());
    }
}
