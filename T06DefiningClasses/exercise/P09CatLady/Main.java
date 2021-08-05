package T06DefiningClasses.exercise.P09CatLady;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Cat> cats = new ArrayList<>();
        String input = "";
        while (!(input = scan.nextLine()).equals("End")) {
            String[] params = input.split("\\s+");
            String breedType = params[0];
            String catName = params[1];
            double characteristic = Double.parseDouble(params[2]);
            switch (breedType) {
                case "Siamese":
                    cats.add(new Siamese(catName, breedType, characteristic));
                    break;
                case "Cymric":
                    cats.add(new Cymric(catName, breedType, characteristic));
                    break;
                case "StreetExtraordinaire":
                    cats.add(new StreetExtraordinaire(catName, breedType, characteristic));
                    break;
            }
        }
        String outputCat = scan.nextLine();
        cats.stream().filter(c->c.getCatName().equals(outputCat)).forEach(System.out::println);
    }
}
