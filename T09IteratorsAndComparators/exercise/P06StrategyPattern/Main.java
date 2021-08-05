package T09IteratorsAndComparators.exercise.P06StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<Person> setByName = new TreeSet<>(new ComparatorByName());
        Set<Person> setByAge = new TreeSet<>(new ComparatorByAge());
        int lines = Integer.parseInt(scan.nextLine());
        while (lines-- > 0) {
            String[] input = scan.nextLine().split("\\s+");
            Person person = new Person(input[0], Integer.parseInt(input[1]));
            setByName.add(person);
            setByAge.add(person);
        }
        setByName.forEach(System.out::println);
        setByAge.forEach(System.out::println);

    }
}
