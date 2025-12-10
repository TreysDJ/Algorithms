package bro.maks.map;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HashMapTest {

    @Test
    void testPut() {
        HashMap<Integer> values = new HashMap<>(64);
        Integer expeted = 5;
        values.put("Obezyana", expeted);
        Integer actual = values.get("Obezyana");
        Assertions.assertEquals(expeted, actual);
    }

    @Test
    void shouldReturnNullWhenNoKey() {
        HashMap<Integer> values = new HashMap<>(64);
        Assertions.assertNull(values.get("Bjerfjldlkrj"));
    }

    @Test
    void shouldRemoveValue() {
        HashMap<Integer> values = new HashMap<>(64);
        values.put("Bj", 4);
        values.put("Bs", 3);
        Assertions.assertEquals(4, values.remove("Bj"));
    }

    @Test
    void testSize() {
        HashMap<Integer> values = new HashMap<>(64);
        values.put("Obj", 4);
        values.put("Zie", 3);
        Assertions.assertEquals(2, values.size());

        values.put("Zie", 10);
        Assertions.assertEquals(2, values.size());

        values.remove("Obj");
        Assertions.assertEquals(1, values.size());

        values.remove("Zie");
        Assertions.assertEquals(0, values.size());
        values.remove("Zie");
        Assertions.assertEquals(0, values.size());
    }

    @Test
    void shouldReturnTrueWhenKeyExists() {
        HashMap<Integer> values = new HashMap<>(64);
        values.put("Bj", 5);
        values.put("Bs", 4);
        Assertions.assertTrue(values.containsKey("Bj"));
    }

    @Test
    void shouldReturnFalseWhenKeyDoesNotExist() {
        HashMap<Integer> values = new HashMap<>(64);
        values.put("Bj", 5);
        values.put("Bs", 4);
        Assertions.assertFalse(values.containsKey("Lox"));
    }

    @Test
    void shouldReturnTrueWhenValueExists() {
        HashMap<Integer> values = new HashMap<>(64);
        values.put("Bj", 5);
        values.put("Bs", 4);
        Assertions.assertTrue(values.containsValue(5));
    }

    @Test
    void shouldReturnFalseWhenValueDoesNotExist() {
        HashMap<Integer> values = new HashMap<>(64);
        values.put("Bj", 5);
        values.put("Bs", 4);
        Assertions.assertFalse(values.containsValue(555));
    }

    @Test
    void shouldReturnTrueWhenValuesIsEmptyNoInput() {
        HashMap<Integer> values = new HashMap<>(64);
        Assertions.assertTrue(values.isEmpty());
    }

    @Test
    void shouldReturnTrueWhenValuesIsEmptyWithInput() {
        HashMap<Integer> values = new HashMap<>(64);
        values.put("Bj", 4);
        values.remove("Bj");
        Assertions.assertTrue(values.isEmpty());
    }

    @Test
    void shouldReturnFalseWhenValuesIsEmptyWithInput() {
        HashMap<Integer> values = new HashMap<>(64);
        values.put("Bj", 4);
        Assertions.assertFalse(values.isEmpty());
    }

    class Person {
        private final int id;
        private final String status;

        public Person(int id, String status) {
            this.id = id;
            this.status = status;
        }

        public boolean equals(Object other) {
            if (!(other instanceof Person)) {
                return false;
            }
            if (((Person) other).id != this.id) {
                return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            return this.id;
        }
    }

    @Test
    void shouldReturnTrueWhenEqualsReturnTrue() {
        HashMap<Person> values = new HashMap<>(64);
        Person maks = new Person(5, "Кто в классику играл в цирке не смеётся");
        Person maksDuplicate = new Person(5, "Перо в заднице не значит что ты павлин");
        values.put("Bjj", maks);
        Assertions.assertTrue(maks.equals(maksDuplicate));

    }

    @Test
    void shouldReturnFalseWhenEqualsReturnFalse() {
        HashMap<Person> values = new HashMap<>(64);
        Person maks = new Person(5, "Кто в классику играл в цирке не смеётся");
        Person dima = new Person(7, "Перо в заднице не значит что ты павлин");
        Assertions.assertFalse(maks.equals(dima));
        Assertions.assertFalse(values.containsValue(dima));
    }

    @Test
    void shouldReturnTrueWhenIdEqualsId() {
        Person maks = new Person(5, "Кто в классику играл в цирке не смеётся");
        Assertions.assertTrue(maks.id == maks.hashCode());
    }

    class dayOfBirthDay {
        private String name;
        private int years;

        private dayOfBirthDay(String key, int value) {
            this.name = key;
            this.years = value;
        }

        @Override
        public boolean equals(Object other) {
            if (!(other instanceof dayOfBirthDay)) {
                return false;
            }
            dayOfBirthDay othe = (dayOfBirthDay) other;
            return othe.name.equals(this.name);
        }

        @Override
        public int hashCode() {
            int hashCode = 1;
            for (int i = 0; i < this.name.length(); i++) {
                int cur = (int) this.name.charAt(i);
                hashCode *= cur;
            }

            return Math.abs(hashCode);
        }
    }

    @Test
    void shouldReturnValueWnenCollisiton() {
        HashMap<dayOfBirthDay> values = new HashMap<>(64);
        dayOfBirthDay max = new dayOfBirthDay("Max", 16);
        dayOfBirthDay dima = new dayOfBirthDay("Xam", 12);
        values.put("max", max);


    }

    @Test
    void shouldReturnTrueWhenEquals() {
        dayOfBirthDay max = new dayOfBirthDay("Max", 16);
        dayOfBirthDay dima = new dayOfBirthDay("Xam", 12);

    }

    @Test
    void testPutsWithCollisionUsingStrings() {
        HashMap<Integer> values = new HashMap<>(16);
        String key1 = "Aa";
        String key2 = "BB";
        values.put(key1, 100);
        values.put(key2, 200);
        Assertions.assertEquals(2, values.size());
        Assertions.assertEquals(100, values.get(key1));
        Assertions.assertEquals(200, values.get(key2));
    }

    @Test
    void testRemovalsWithCollisionUsingStrings() {
        HashMap<Integer> values = new HashMap<>(16);
        String key1 = "Aa";
        String key2 = "BB";
        values.put(key1, 100);
        values.put(key2, 200);
        Assertions.assertEquals(2, values.size());
        Integer removedValue = values.remove(key1);
        Assertions.assertEquals(100, removedValue);
        Assertions.assertEquals(1, values.size());
        Assertions.assertNull(values.get(key1));
        Assertions.assertEquals(200, values.get(key2));
    }

    @Test
    void testNullPutDefault() {
        HashMap<Integer> values = new HashMap<>(64);
        String key1 = null;
        values.put(key1, 100);
        Assertions.assertEquals(1, values.size());
        Assertions.assertTrue(values.containsKey(key1));
    }

    @Test
    void testNullRemoveDefault() {
        HashMap<Integer> values = new HashMap<>(64);
        String key1 = null;
        values.put(key1, 100);
        Assertions.assertTrue(values.containsKey(key1));
        values.remove(key1);
        Assertions.assertEquals(0, values.size());
        Assertions.assertEquals(null, values.remove(key1));
    }

    @Test
    void testNullGetDefaultAndWhenKeyEquals() {
        HashMap<Integer> values = new HashMap<>(64);
        String key1 = null;
        values.put(key1, 100);
        Assertions.assertEquals(1, values.size());
        Assertions.assertEquals(100, values.get(key1));
        values.put(null, 200);
        Assertions.assertEquals(1, values.size());
        Assertions.assertEquals(200, values.get(null));
    }

    @Test
    void testPutAndGetNullValue() {
        HashMap<String> map = new HashMap<>(16);
        map.put("key1", null);
        Assertions.assertEquals(1, map.size());
        Assertions.assertTrue(map.containsKey("key1"));
        Assertions.assertNull(map.get("key1"));
    }

    @Test
    void testContainsNullValue() {
        HashMap<String> map = new HashMap<>(16);
        map.put("key1", "value1");
        Assertions.assertFalse(map.containsValue(null));
        map.put("key2", null);
        Assertions.assertTrue(map.containsValue(null));
    }

    @Test
    void testPutGetRemoveNullKeyAndNullValue() {
        HashMap<String> map = new HashMap<>(16);
        map.put(null, null);

        Assertions.assertEquals(1, map.size());
        Assertions.assertTrue(map.containsKey(null));
        Assertions.assertNull(map.get(null));
        Assertions.assertTrue(map.containsValue(null));

        map.remove(null);
        Assertions.assertTrue(map.isEmpty());
        Assertions.assertFalse(map.containsKey(null));
    }
}
