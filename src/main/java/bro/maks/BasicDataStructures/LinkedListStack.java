package bro.maks.BasicDataStructures;

public class LinkedListStack<E> implements Stack<E> {
    private Node top;
    private int size;

    public LinkedListStack() {
        this.top = null;
        this.size = 0;
    }

    private class Node {
        private final E value;
        private Node next;

        public Node(E value) {
            this.value = value;
            this.next = null;
        }
    }

    @Override
    public void push(E element) {
        Node node = new Node(element);
        node.next = this.top;
        this.top = node;
        this.size++;
    }

    @Override
    public E pop() {
        if (this.top == null) {
            return null;
        }

        Node current = this.top;
        this.top = current.next;
        this.size--;
        return current.value;
    }

    @Override
    public E peek() {
        if (!isEmpty()) {
            return this.top.value;
        } else {
            return null;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
