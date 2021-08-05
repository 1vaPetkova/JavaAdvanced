package T08Generics.exercise.P08CustomListSorter;

import java.util.Collections;
import java.util.List;


public class Sorter {
    public static <T extends Comparable<T>> void sort(List<T> elements) {
        Collections.sort(elements);
    }
}
