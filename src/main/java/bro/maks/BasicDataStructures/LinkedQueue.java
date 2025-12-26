package bro.maks.BasicDataStructures;

public class LinkedQueue<E> implements Queue<E> {
    private Node head;
    private Node tail;
    private int currentSize;

    public LinkedQueue() {
        this.head = null;
        this.tail = null;
        this.currentSize = 0;
    }

    private class Node {
        private Node next;
        private E value;

        private Node(E value) {
            this.value = value;
            this.next = null;
        }
    }

    @Override
    public void push(E element) {
        Node node = new Node(element);
        if (this.tail == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = node;
        }
        this.currentSize++;
    }

    @Override
    public E pop() {
        if (!isEmpty()) {
            E current = this.head.value;
            this.head = this.head.next;
            this.currentSize--;
            return current;
        }
        return null;
    }

    @Override
    public E peek() {
        if (!isEmpty()) {
            return this.head.value;
        } else {
            return null;
        }
    }

    @Override
    public int size() {
        return this.currentSize;
    }

    public boolean isEmpty() {
        return this.currentSize == 0;
    }
}
