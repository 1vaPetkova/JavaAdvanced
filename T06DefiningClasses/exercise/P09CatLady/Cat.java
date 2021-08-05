package T06DefiningClasses.exercise.P09CatLady;

public class Cat {
    private final String catName;
    private final String breedType;

    public Cat(String catName,String breedType) {
        this.catName = catName;
        this.breedType = breedType;
    }

    public String getCatName() {
        return catName;
    }

    public String getBreedType() {
        return breedType;
    }

    @Override
    public String toString() {
        return String.format("%s %s",this.breedType,this.catName);
    }
}
