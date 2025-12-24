package bro.maks.BasicDataStructures;

public class ArrayStack<E> implements Stack<E> {
    private E[] arr;
    private int currentSize = 0;

    public ArrayStack(int size) {
        this.arr = (E[]) new Object[size];
    }

    @Override
    public void push(E element) {
        if (this.currentSize == this.arr.length) {
            multipleSize();
        }
        this.arr[this.currentSize] = element;
        this.currentSize++;
    }

    @Override
    public E pop() {
        if (!isEmpty()) {
            E element = this.arr[this.currentSize - 1];
            this.arr[this.currentSize - 1] = null;
            this.currentSize--;
            return element;
        } else {
            return null;
        }
    }

    @Override
    public E peek() {
        if (!isEmpty()) {
            return this.arr[this.currentSize - 1];
        }
        return null;
    }

    private void multipleSize() {
        int newSize;

        if (this.arr.length == 0) {
            newSize = 1;
        } else {
            newSize = this.arr.length * 2;
        }

        E[] newArr = (E[]) new Object[newSize];

        for (int i = 0; i < this.currentSize; i++) {
            newArr[i] = this.arr[i];
        }
        this.arr = newArr;
    }

    @Override
    public int size() {
        return this.currentSize;
    }

    public boolean isEmpty() {
        return this.currentSize == 0;
    }
}