package bro.maks.Algorithms;

import bro.maks.JavaAlgorithmsCourse.BackPack;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BackPackTest {
    // привет
    @Test
    void testBasicScenario() {
        int capacity = 4;
        int[] weights = {1, 3, 4};
        assertEquals(4, BackPack.take(capacity, weights));
    }

    @Test
    void testGreedyFailsScenario() {
        int capacity = 10;
        int[] weights = {6, 5, 5};
        assertEquals(10, BackPack.take(capacity, weights));
    }

    @Test
    void testAllItemsFit() {
        int capacity = 20;
        int[] weights = {2, 3, 5};
        assertEquals(10, BackPack.take(capacity, weights));
    }

    @Test
    void testNoItemsFit() {
        int capacity = 5;
        int[] weights = {6, 7};
        assertEquals(0, BackPack.take(capacity, weights));
    }

    @Test
    void testZeroCapacity() {
        int capacity = 0;
        int[] weights = {1, 2, 3};
        assertEquals(0, BackPack.take(capacity, weights));
    }

    @Test
    void testNoItems() {
        int capacity = 10;
        int[] weights = {};
        assertEquals(0, BackPack.take(capacity, weights));
    }
}