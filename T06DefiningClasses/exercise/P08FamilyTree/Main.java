package T06DefiningClasses.exercise.P08FamilyTree;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String personId = scan.nextLine();
        List<Person> people = new ArrayList<>();
        Map<String, List<String>> parentAndChildren = new LinkedHashMap<>();
        String input;

        while (!"End".equals(input = scan.nextLine())) {
            if (input.contains(" - ")) {
                String[] data = input.split(" - ");
                String parentId = data[0];
                String childrenId = data[1];
                parentAndChildren.putIfAbsent(parentId, new ArrayList<>());
                parentAndChildren.get(parentId).add(childrenId);
            } else {
                String[] data = input.split("\\s+");
                String name = data[0] + " " + data[1];
                String birthDate = data[2];
                people.add(new Person(name, birthDate));
            }
        }
        parentAndChildren.forEach((parentId, children) -> {
            Person parent = findPerson(people, parentId);
            children.stream().map(childId -> findPerson(people, childId)).forEach(parent::addChild);
        });
        Person forPerson = findPerson(people, personId);
        System.out.println(getFamilyTreeFor(forPerson));
    }
    public static String getFamilyTreeFor(Person person) {
        return  person.toString() + System.lineSeparator() +
                "Parents:" + System.lineSeparator() +
                person.getParents().stream().map(Person::toString).collect(Collectors.joining(System.lineSeparator())) + (person.getParents().isEmpty() ? "" : System.lineSeparator()) +
                "Children:" + System.lineSeparator() + person.getChildren().stream().map(Person::toString).collect(Collectors.joining(System.lineSeparator()));
    }

    public static Person findPerson(List<Person> people, String personId) {
        return people.stream()
                .filter(person -> person.getBirthDate().equals(personId) || person.getName().equals(personId))
                .findFirst()
                .orElseThrow();
    }
}
