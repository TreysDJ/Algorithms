package bro.maks.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class  HashSetTest {

    private Set<String> set;

    @BeforeEach
    void setUp() {
        set = new HashSet<>();
    }

    @Test
    void testAddSize() {
        set.add("дима");
        set.add("макс");

        assertEquals(2, set.size());

        assertTrue(set.contains("дима"));
        assertTrue(set.contains("макс"));

        set.add("дима");
        assertEquals(2, set.size());

        assertFalse(set.contains("петушары"));
    }

    @Test
    void testRemove() {
        set.add("дима");
        set.add("макс");

        String removed = set.remove("дима");
        assertEquals("дима", removed);
        assertEquals(1, set.size());

        assertFalse(set.contains("дима"));
    }

    @Test
    void testNullElementHandling() {
        set.add(null);
        assertEquals(1, set.size());
        assertTrue(set.contains(null));

        set.add(null);
        assertEquals(1, set.size());

        String removedNull = set.remove(null);
        assertNull(removedNull);
        assertEquals(0, set.size());
        assertFalse(set.contains(null));
    }
}
