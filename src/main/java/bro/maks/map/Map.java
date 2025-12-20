package bro.maks.map;

import java.util.Objects;

public interface Map<V> {
    V get(String key);

    void put(String key, V value);

    V remove(String key);

    int size();

    boolean isEmpty();

    boolean containsKey(String key);

    boolean containsValue(V value);
}