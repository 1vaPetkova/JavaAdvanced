package T08Generics.exercise.P06GenericCountMethodDoubles;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        T tmp = elements.get(firstIndex);
        elements.set(firstIndex, elements.get(secondIndex));
        elements.set(secondIndex, tmp);
    }

    public long countGreaterElements(T element) {
        return this.elements.stream().filter(e -> e.compareTo(element)>0).count();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        elements.forEach(e -> sb.append(String.format("%s: %s\n", e.getClass().getName(), e)));
        return sb.toString();
    }
}
