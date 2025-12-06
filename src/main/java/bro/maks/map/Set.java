package bro.maks.map;

public interface Set<V> {
    void add(String element);

    String remove(String element);

    boolean contains(String element);

    int size();
}
