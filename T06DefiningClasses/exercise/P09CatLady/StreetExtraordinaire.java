package T06DefiningClasses.exercise.P09CatLady;

public class StreetExtraordinaire extends Cat {
    private final double meowsDecibels;

    public StreetExtraordinaire(String catName, String breedType, double meowsDecibels) {
        super(catName,breedType);
        this.meowsDecibels = meowsDecibels;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f",getBreedType(),getCatName(), this.meowsDecibels);
    }
}
