package bro.maks.map;

import java.util.Objects;

class HashMap<V> implements Map<V> {
    private final Entry<V>[] entries;
    private int current;

    private static class Entry<V> {
        private final String key;
        private V value;
        private Entry<V> next;

        private Entry(String key, V value, Entry<V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @SuppressWarnings("unchecked")
    public HashMap(int size) {
        this.entries = new Entry[size];
        this.current = 0;
    }

    public V get(String key) {
        int index = getIndex(key);
        for (Entry<V> entry = this.entries[index]; entry != null; entry = entry.next) {
            if (Objects.equals(entry.key, key)) {
                return entry.value;
            }
        }
        return null;
    }

    public void put(String key, V value) {
        int index = getIndex(key);
        Entry<V> head = this.entries[index];

        for (Entry<V> entry = head; entry != null; entry = entry.next) {
            if (Objects.equals(entry.key, key)) {
                entry.value = value;
                return;
            }
        }

        Entry<V> newEntry = new Entry<>(key, value, head);
        this.entries[index] = newEntry;
        this.current++;
    }

    public V remove(String key) {
        int index = getIndex(key);
        Entry<V> head = this.entries[index];
        Entry<V> prev = null;
        Entry<V> currentEntry = head;

        while (currentEntry != null) {
            if (Objects.equals(currentEntry.key, key)) {
                if (prev == null) {
                    this.entries[index] = currentEntry.next;
                } else {
                    prev.next = currentEntry.next;
                }
                this.current--;
                return currentEntry.value;
            }
            prev = currentEntry;
            currentEntry = currentEntry.next;
        }
        return null;
    }

    public int size() {
        return this.current;
    }

    public boolean isEmpty() {
        return this.current == 0;
    }

    public boolean containsKey(String key) {
        int index = getIndex(key);
        for (Entry<V> entry = this.entries[index]; entry != null; entry = entry.next) {
            if (Objects.equals(entry.key, key)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(V value) {
        for (int i = 0; i < this.entries.length; i++) {
            for (Entry<V> entry = this.entries[i]; entry != null; entry = entry.next) {
                if (Objects.equals(value, entry.value)) {
                    return true;
                }
            }
        }
        return false;
    }

    private int getIndex(String key) {
        if (key == null) {
            return 0;
        }
        return Math.abs(key.hashCode()) % this.entries.length;
    }
}
