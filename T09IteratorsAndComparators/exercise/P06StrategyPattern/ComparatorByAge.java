package T09IteratorsAndComparators.exercise.P06StrategyPattern;

import java.util.Comparator;

public class ComparatorByAge implements Comparator<Person> {

    @Override
    public int compare(Person f, Person s) {
        return Integer.compare(f.getAge(), s.getAge());
    }
}
