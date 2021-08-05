package T06DefiningClasses.exercise.P09CatLady;

public class Cymric extends Cat {
    private final double furLength;

    public Cymric(String catName, String breedType, double furLength) {
        super(catName, breedType);
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", getBreedType(), getCatName(), this.furLength);
    }
}
