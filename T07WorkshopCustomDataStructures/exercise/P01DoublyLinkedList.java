package T07WorkshopCustomDataStructures.exercise;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class P01DoublyLinkedList {
    private class Node {
        private int element;
        private Node next;
        private Node prev;

        private Node(int element) {
            this.element = element;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int element) {
        Node newNode = new Node(element);
        if (this.size == 0) {
            this.head = this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        this.size++;
    }

    public void addLast(int element) {
        Node newNode = new Node(element);
        if (this.size == 0) {
            this.head = this.tail = newNode;
        } else {
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }

    public int size() {
        return this.size;
    }

    public int get(int index) {
        ensureIndex(index);
        if (index <= this.size / 2) {
            Node firstNode = this.head;
            for (int i = 0; i < index; i++) {
                firstNode = firstNode.next;
            }
            return firstNode.element;
        }
        Node lastNode = this.tail;
        for (int i = this.size - 1; i > index; i--) {
            lastNode = lastNode.prev;
        }
        return lastNode.element;
    }

    public int removeFirst() {
        ensureNotEmpty();
        Node removedElement = this.head;
        if (this.size == 1) {
            this.head = this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
        }
        this.size--;

        return removedElement.element;
    }

    public int removeLast() {
        ensureNotEmpty();
        Node removedElement = this.tail;
        if (this.size == 1) {
            this.head = this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
        this.size--;
        return removedElement.element;
    }

    public void forEach(Consumer<Integer> consumer) {
        Node current = this.head;
        while (current != null) {
            consumer.accept(current.element);
            current = current.next;
        }
    }

    public int[] toArray() {
        int[] array = new int[this.size];
        Node current = this.head;
        int index = 0;
        while (current != null) {
            array[index++] = current.element;
            current = current.next;
        }
        return array;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private void ensureNotEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
    }

    public void ensureIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new NoSuchElementException();
        }
    }

}
