package bro.maks.BasicDataStructures;

public interface Queue<E> {
    void push(E element);

    E pop();

    E peek();

    int size();

    boolean isEmpty();
}
