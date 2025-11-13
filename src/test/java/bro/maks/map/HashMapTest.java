package bro.maks.map;


import bro.maks.JavaAlgorithmsCourse.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HashMapTest {
    // привет

    @Test
    void testPut() {
        Map.HashMap<Integer> values = new Map.HashMap<Integer>(64);
        Integer expeted = 5;
        values.put("Obezyana", expeted);
        Integer actual = values.get("Obezyana");
        Assertions.assertEquals(expeted, actual);
    }

    @Test
    void shouldReturnNullWhenNoKey() {
        Map.HashMap<Integer> values = new Map.HashMap<Integer>(64);
        Assertions.assertNull(values.get("Bjerfjldlkrj"));
    }

    @Test
    void shouldRemoveValue() {
        Map.HashMap<Integer> values = new Map.HashMap<Integer>(64);
        values.put("Bj", 4);
        values.put("Bs", 3);
        Assertions.assertEquals(4, values.remove("Bj"));
    }

    @Test
    void testSize() {
        Map.HashMap<Integer> values = new Map.HashMap<Integer>(64);
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
        Map.HashMap<Integer> values = new Map.HashMap<Integer>(64);
        values.put("Bj", 5);
        values.put("Bs", 4);
        Assertions.assertTrue(values.containsKey("Bj"));
    }

    @Test
    void shouldReturnFalseWhenKeyDoesNotExist() {
        Map.HashMap<Integer> values = new Map.HashMap<Integer>(64);
        values.put("Bj", 5);
        values.put("Bs", 4);
        Assertions.assertFalse(values.containsKey("Lox"));
    }

    @Test
    void shouldReturnTrueWhenValueExists() {
        Map.HashMap<Integer> values = new Map.HashMap<Integer>(64);
        values.put("Bj", 5);
        values.put("Bs", 4);
        Assertions.assertTrue(values.containsValue(5));
    }

    @Test
    void shouldReturnFalseWhenValueDoesNotExist() {
        Map.HashMap<Integer> values = new Map.HashMap<Integer>(64);
        values.put("Bj", 5);
        values.put("Bs", 4);
        Assertions.assertFalse(values.containsValue(555));
    }

    @Test
    void shouldReturnTrueWhenValuesIsEmptyNoInput() {
        Map.HashMap<Integer> values = new Map.HashMap<Integer>(64);
        Assertions.assertTrue(values.isEmpty());
    }

    @Test
    void shouldReturnTrueWhenValuesIsEmptyWithInput() {
        Map.HashMap<Integer> values = new Map.HashMap<Integer>(64);
        values.put("Bj", 4);
        values.remove("Bj");
        Assertions.assertTrue(values.isEmpty());
    }

    @Test
    void shouldReturnFalseWhenValuesIsEmptyWithInput() {
        Map.HashMap<Integer> values = new Map.HashMap<Integer>(64);
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
        Map.HashMap<Person> values = new Map.HashMap<>(64);
        Person maks = new Person(5, "Кто в классику играл в цирке не смеётся");
        Person maksDuplicate = new Person(5, "Перо в заднице не значит что ты павлин");
        values.put("Bjj", maks);
        Assertions.assertTrue(maks.equals(maksDuplicate));

    }

    @Test
    void shouldReturnFalseWhenEqualsReturnFalse() {
        Map.HashMap<Person> values = new Map.HashMap<>(64);
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
        Map.HashMap<dayOfBirthDay> values = new Map.HashMap<>(64);
        dayOfBirthDay max = new dayOfBirthDay("Max", 16);
        dayOfBirthDay dima = new dayOfBirthDay("Xam", 12);
        values.put("max", max);


    }

    @Test
    void shouldReturnTrueWhenEquals() {
        dayOfBirthDay max = new dayOfBirthDay("Max", 16);
        dayOfBirthDay dima = new dayOfBirthDay("Xam", 12);

    }
}
