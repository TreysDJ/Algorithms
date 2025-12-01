package bro.maks.Algorithms;

import bro.maks.JavaAlgorithmsCourse.LIS;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LISTest {
    // привет

    @Test
    void testBasicDivisibleSequence() {
        int[] arr = {2, 3, 4, 9, 8, 16};
        assertEquals(4, LIS.LISBottomUp(arr));
    }

    @Test
    void testEmptyArray() {
        int[] arr = {};
        assertEquals(0, LIS.LISBottomUp(arr));
    }

    @Test
    void testSingleElementArray() {
        int[] arr = {100};
        assertEquals(1, LIS.LISBottomUp(arr));
    }

    @Test
    void testNoDivisiblePairs() {
        int[] arr = {7, 13, 5, 19};
        assertEquals(1, LIS.LISBottomUp(arr));
    }

    @Test
    void testWithDuplicates() {
        int[] arr = {3, 6, 3, 12};
        assertEquals(3, LIS.LISBottomUp(arr));
    }

    @Test
    void testAllElementsSame() {
        int[] arr = {5, 5, 5, 5};
        assertEquals(4, LIS.LISBottomUp(arr));
    }

    @Test
    void testWithOneAtStart() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        assertEquals(4, LIS.LISBottomUp(arr));
    }

    @Test
    void testReverseOrder() {
        int[] arr = {27, 9, 3, 1};
        assertEquals(1, LIS.LISBottomUp(arr));
    }

    @Test
    void testComplexCase() {
        int[] arr = {2, 5, 6, 4, 10, 15, 18, 20};
        assertEquals(3, LIS.LISBottomUp(arr));
    }
}
