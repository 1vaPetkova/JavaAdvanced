package T08Generics.lab.P04ListUtilities;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = List.of(13, 42, 73, 69, -66);
        System.out.println(ListUtils.getMax(integers));
        System.out.println(ListUtils.getMin(integers));

    }
}
