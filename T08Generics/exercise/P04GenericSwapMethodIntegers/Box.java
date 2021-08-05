package T08Generics.exercise.P04GenericSwapMethodIntegers;

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
    public void swap(int firstIndex, int secondIndex){
        T tmp = elements.get(firstIndex);
        elements.set(firstIndex, elements.get(secondIndex));
        elements.set(secondIndex, tmp);
    }
}
