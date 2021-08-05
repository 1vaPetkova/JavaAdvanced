package T09IteratorsAndComparators.exercise.P02Collection;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListyIterator implements Iterable<String> {
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
        return this.index < this.list.size() - 1;

    }

    public void print() {
        if (this.list.isEmpty()) {
            System.out.println("Invalid Operation!");
        } else {
            System.out.println(this.list.get(this.index));
        }
    }

    public void printAll() {
        for (String s : this.list) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < list.size() - 1;
            }

            @Override
            public String next() {
                return list.get(index++);
            }
        };
    }


}
