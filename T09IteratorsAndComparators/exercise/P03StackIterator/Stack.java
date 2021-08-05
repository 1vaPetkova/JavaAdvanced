package T09IteratorsAndComparators.exercise.P03StackIterator;


import java.util.Iterator;

public class Stack<Integer> implements Iterable<Integer> {

    private Node<Integer> top;
    private int size;

    public Stack() {
        this.top = null;
    }

    public void push(int newElement) {
        Node<Integer> newNode = new Node<>(newElement);
        newNode.prev = this.top;
        this.top = newNode;
        this.size++;
    }

    public int pop() {
        if (this.size <= 0) {
            System.out.println("No elements");
            return 0;
        } else {
            Node<Integer> removedElement = this.top;
            this.top = this.top.prev;
            this.size--;
            return removedElement.element;
        }
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        while (this.top != null) {
            sb.append(pop()).append(System.lineSeparator());
        }
        System.out.print(sb);
        System.out.print(sb);
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private Node<Integer> current = top;

            @Override
            public boolean hasNext() {
                return this.current != null;
            }

            @Override
            public Integer next() {
                int currentValue = this.current.element;
                this.current = this.current.prev;
                return (Integer) java.lang.Integer.valueOf(currentValue);
            }
        };
    }
}
