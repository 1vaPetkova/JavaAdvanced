package T09IteratorsAndComparators.exercise.P04Froggy;

import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {
    private int[] stones;

    public Lake(int[] stones) {
        this.stones = stones;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int index = 0;
            private int lastEvenIndex = stones.length % 2 == 0 ? stones.length - 2 : stones.length - 1;

            @Override
            public boolean hasNext() {
                return this.index < stones.length;
            }

            @Override
            public Integer next() {
                if (this.index == lastEvenIndex) {
                    int element = stones[index];
                    this.index = 1;
                    return element;
                }
                int element = stones[index];
                this.index += 2;
                return element;
            }
        };
    }
}
