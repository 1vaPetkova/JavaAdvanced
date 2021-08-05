package T07WorkshopCustomDataStructures.lab.P02CustomStack;

import java.util.Iterator;
import java.util.function.Consumer;

public class CustomStack implements Iterable<Integer> {
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private Node current = top;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Integer next() {
                int value = current.element;
                current = current.prev;
                return value;
            }
        };
    }

    private static class Node {//visible from outside
        private int element;
        private Node prev;

        public Node(int element) {
            this.element = element;
        }
    }

    private Node top;
    private int size;

    public CustomStack() {
    }

    public void push(int element) {
        Node newNode = new Node(element);
        if (top != null) {
            newNode.prev = top;
        }
        top = newNode;
        this.size++;
    }

    public int pop() {
        ensureNotEmpty();
        int removedElement = top.element;
        Node oldTop = top;
        top = top.prev;
        oldTop.prev = null;
        this.size--;
        return removedElement;
    }


    public int peek() {
        ensureNotEmpty();
        return top.element;
    }

//    public void forEach(Consumer<Integer> consumer) {
//        Node current = top;
//        while (current != null) {
//            consumer.accept(current.element);
//            current = current.prev;
//        }
//    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }


    private void ensureNotEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
    }

}
