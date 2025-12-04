package bro.maks.map;


import java.util.HashMap;

public class HashSet<V> implements Set<V> {
    private HashMap<V, Object> map;
    private static final Object plug = null;

    public HashSet() {
        map = new HashMap<>();
    }

    @Override
    public void add(V element) {
        map.put(element, plug);
    }

    @Override
    public V remove(Object element) {
        if (map.containsKey(element)) {
            map.remove(element);
            V castedElement = (V) element;
            return castedElement;
        }
        return null;
    }

    @Override
    public boolean contains(Object element) {
        return map.containsKey(element);
    }

    @Override
    public int size() {
        return map.size();
    }
}
