package T06DefiningClasses.exercise.P09CatLady;

public class Siamese extends Cat{
    private final double earSize;

    public Siamese(String catName, String breedType,double earSize) {
        super(catName,breedType);
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f",getBreedType(),getCatName(), this.earSize);
    }
}
