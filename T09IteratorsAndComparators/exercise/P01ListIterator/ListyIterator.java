package T09IteratorsAndComparators.exercise.P01ListIterator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListyIterator {
    private List<String> list;
    private int index;

    public ListyIterator(List<String> list) {
        this.list = list;
        if (list.isEmpty()) {
            this.index = -1;
        } else {
            this.index = 0;
        }
    }

    public boolean move() {
        if (hasNext()) {
            this.index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
            return this.index < this.list.size()-1;

    }

    public void print() {
        if (this.list.isEmpty()) {
            System.out.println("Invalid Operation!");
        } else {
            System.out.println(this.list.get(this.index));
        }
    }
}
