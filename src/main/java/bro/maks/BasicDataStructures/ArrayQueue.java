package bro.maks.BasicDataStructures;

public class ArrayQueue<E> implements Queue<E> {
    private E[] arr;
    private int currentSize;
    private int head;
    private int tail;

    public ArrayQueue(int size) {
        this.arr = (E[]) new Object[size];
    }

    @Override
    public void push(E element) {
        if (this.currentSize == this.arr.length) {
            multipleSize();
        }
        this.arr[this.tail] = element;
        this.tail = (this.tail + 1) % this.arr.length;
        this.currentSize++;
    }

    @Override
    public E pop() {
        if (!isEmpty()) {
            E current = this.arr[this.head];
            this.arr[this.head] = null;
            this.head = (this.head + 1) % this.arr.length;
            this.currentSize--;
            return current;
        }
        return null;
    }

    @Override
    public E peek() {
        if (!isEmpty()) {
            return this.arr[head];
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

    public void multipleSize() {
        int size;
        int index = 0;

        if (this.arr.length == 0) {
            size = 1;
        } else {
            size = this.arr.length;
        }

        E[] newArr = (E[]) new Object[size * 2];

        for (int i = 0; i < this.currentSize; i++) {
            int oldIndex = (this.head + i) % this.arr.length;
            newArr[index] = this.arr[oldIndex];
        }
        this.head = 0;
        this.tail = this.currentSize;
        this.arr = newArr;
    }
}

