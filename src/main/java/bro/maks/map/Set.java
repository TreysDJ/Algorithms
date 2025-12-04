package bro.maks.map;

public interface Set<V> {
    void add(V element);

    V remove(Object element);

    boolean contains(Object element);

    int size();
}
