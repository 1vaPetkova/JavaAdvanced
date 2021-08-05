package T09IteratorsAndComparators.exercise.P05ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        List<Person> people = new ArrayList<>();
        while (!(input = scan.nextLine()).equals("END")) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String town = tokens[2];
            Person person = new Person(name, age, town);
            people.add(person);
        }

        int n = Integer.parseInt(scan.nextLine());
        int countEqual = 0;
        if (n <= people.size()-1) {
            Person other = people.get(n);
            for (Person p : people) {
                if (p.compareTo(other) == 0) {
                    countEqual++;
                }
            }
                System.out.printf("%d %d %d",countEqual,people.size()-countEqual, people.size());
        } else {
            System.out.println("No matches");
        }
    }
}
