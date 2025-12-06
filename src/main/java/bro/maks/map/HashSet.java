package bro.maks.map;

public class HashSet<V> implements Set<V> {
    private bro.maks.map.HashMap<Object> map;
    private static final Object plug = null;

    public HashSet(int capacity) {
        map = new bro.maks.map.HashMap<>(capacity);
    }

    @Override
    public void add(String element) {
        if (!(map.containsKey(element))) {
            map.put(element, plug);
        }
    }

    @Override
    public String remove(String element) {
        if (element == null) {
            if (map.containsKey(element)) {
                map.remove(element);
                return null;
            }
        }

        if (map.containsKey(element)) {
            map.remove(element);
            return element;
        }
        return null;
    }

    @Override
    public boolean contains(String element) {
        return map.containsKey(element);

    }

    @Override
    public int size() {
        return map.size();
    }
}
