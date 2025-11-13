package bro.maks.JavaAlgorithmsCourse;

public interface Map<V> {
    // привет
    V get(String key);

    V put(String key, V value);

    V remove(String key);

    int size();

    boolean isEmpty();

    boolean containsKey(String key);

    boolean containsValue(V value);

    class HashMap<V> implements Map<V> {
        private final Object[] entries;
        private int current;

        private final class Entry {
            private final String key;
            private final V value;

            private Entry(String key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        public HashMap(int size) {
            this.entries = new Object[size];
            this.current = 0;
        }

        @SuppressWarnings("unchecked")
        public V get(String key) {
            int index = hashCode(key) % this.entries.length;
            Entry entry = (Entry) this.entries[index];
            if (entry != null) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
            return null;
        }

        public V put(String key, V value) {
            Entry entry = new Entry(key, value);
            int index = hashCode(key) % this.entries.length;
            if (this.entries[index] == null) {
                this.current++;
                this.entries[index] = entry;
                return value;
            }
            return value;
        }

        @SuppressWarnings("unchecked")
        public V remove(String key) {
            int index = hashCode(key) % this.entries.length;

            Entry entry = (Entry) this.entries[index];
            if (entry == null) {
                return null;
            }
            this.entries[index] = null;
            this.current--;
            return entry.value;
        }

        public int size() {
            return this.current;
        }

        public boolean isEmpty() {
            // todo test
            return this.current == 0;
        }

        public boolean containsKey(String key) {
            int index = hashCode(key) % this.entries.length;
            return this.entries[index] != null;
        }

        public boolean containsValue(V value) {
            for (int i = 0; i < this.entries.length; i++) {
                // todo equals вместо ==
                Entry entry = (Entry) this.entries[i];
                if (entry != null) {
                    if (entry.value.equals(value)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private static int hashCode(String key) {
            int hashCode = 1;
            for (int i = 0; i < key.length(); i++) {
                int cur = (int) key.charAt(i);
                hashCode *= cur;
            }

            return Math.abs(hashCode);
        }
    }
}