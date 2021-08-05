package T06DefiningClasses.exercise.P01OpinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());
        List<Person> people = new ArrayList<>();
        while (lines-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");
            if (Integer.parseInt(tokens[1]) > 30) {
                people.add(new Person(tokens[0], Integer.parseInt(tokens[1])));
            }
        }
        people.stream().sorted(Comparator.comparing(Person::getName))
                .forEach(p -> System.out.println(p.getName() + " - " + p.getAge()));
    }
}
