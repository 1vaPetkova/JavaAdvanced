package T06DefiningClasses.exercise.P07Google;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        HashMap<String, People> map = new LinkedHashMap<>();
        while (!(input = scan.nextLine()).equals("End")) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            map.putIfAbsent(name, new People(name, null, null));
            switch (tokens[1]) {
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    Company company = new Company(companyName, department, salary);
                    map.get(name).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    map.get(name).getPokemonsList().add(pokemon);
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];
                    Parent parent = new Parent(parentName, parentBirthday);
                    map.get(name).getParentsList().add(parent);
                    break;
                case "children":
                    String childName = tokens[2];
                    String childBirthday = tokens[3];
                    Child child = new Child(childName, childBirthday);
                    map.get(name).getChildrenList().add(child);
                    break;
                case "car":
                    String carModel = tokens[2];
                    int carSpeed = Integer.parseInt(tokens[3]);
                    Car car = new Car(carModel, carSpeed);
                    map.get(name).setCar(car);
                    break;
            }
        }
        String filterName = scan.nextLine();
        map.entrySet().stream().filter(e -> e.getKey().equals(filterName))
                .forEach(p -> System.out.println(p.getValue()));
    }
}
