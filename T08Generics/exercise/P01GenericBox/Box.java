package T08Generics.exercise.P01GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        elements.forEach(e -> sb.append(String.format("%s: %s\n", e.getClass().getName(), e)));
        return sb.toString();
    }
}
