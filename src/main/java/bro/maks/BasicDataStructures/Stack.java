package bro.maks.BasicDataStructures;

public interface Stack<E> {
    void push(E element);

    E pop();

    E peek();

    int size();
}
