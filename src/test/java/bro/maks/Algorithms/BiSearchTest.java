package bro.maks.Algorithms;

import bro.maks.JavaAlgorithmsCourse.BiSearch;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BiSearchTest {
    // привет

    @Test
    void testBiSearch_targetPresent_middle() {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 3;
        int expected = 2;
        int actual = BiSearch.biSearch(arr, target, 0, arr.length - 1);
        assertEquals(expected, actual);
    }

    @Test
    void testBiSearch_targetPresent_firstElement() {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 1;
        int expected = 0;
        int actual = BiSearch.biSearch(arr, target, 0, arr.length - 1);
        assertEquals(expected, actual);
    }

    @Test
    void testBiSearch_targetPresent_lastElement() {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 5;
        int expected = 4;
        int actual = BiSearch.biSearch(arr, target, 0, arr.length - 1);
        assertEquals(expected, actual);
    }

    @Test
    void testBiSearch_targetNotPresent_betweenElements() {
        int[] arr = {1, 3, 5, 7, 9};
        int target = 4;
        int expected = -1;
        int actual = BiSearch.biSearch(arr, target, 0, arr.length - 1);
        assertEquals(expected, actual);
    }

    @Test
    void testBiSearch_targetNotPresent_smallerThanFirst() {
        int[] arr = {10, 20, 30};
        int target = 5;
        int expected = -1;
        int actual = BiSearch.biSearch(arr, target, 0, arr.length - 1);
        assertEquals(expected, actual);
    }

    @Test
    void testBiSearch_targetNotPresent_largerThanLast() {
        int[] arr = {10, 20, 30};
        int target = 35;
        int expected = -1;
        int actual = BiSearch.biSearch(arr, target, 0, arr.length - 1);
        assertEquals(expected, actual);
    }

    @Test
    void testBiSearch_emptyArray() {
        int[] arr = {};
        int target = 10;
        int expected = -1;
        int actual = BiSearch.biSearch(arr, target, 0, arr.length - 1);
        assertEquals(expected, actual);
    }

    @Test
    void testBiSearch_singleElementArray_targetPresent() {
        int[] arr = {7};
        int target = 7;
        int expected = 0;
        int actual = BiSearch.biSearch(arr, target, 0, arr.length - 1);
        assertEquals(expected, actual);
    }

    @Test
    void testBiSearch_singleElementArray_targetNotPresent() {
        int[] arr = {7};
        int target = 5;
        int expected = -1;
        int actual = BiSearch.biSearch(arr, target, 0, arr.length - 1);
        assertEquals(expected, actual);
    }

    @Test
    void testBiSearch_evenLengthArray_targetPresent() {
        int[] arr = {2, 4, 6, 8};
        int target = 6;
        int expected = 2;
        int actual = BiSearch.biSearch(arr, target, 0, arr.length - 1);
        assertEquals(expected, actual);
    }

    @Test
    void testBiSearch_oddLengthArray_targetPresent() {
        int[] arr = {1, 3, 5, 7, 9};
        int target = 7;
        int expected = 3;
        int actual = BiSearch.biSearch(arr, target, 0, arr.length - 1);
        assertEquals(expected, actual);
    }

    @Test
    void testBiSearch_duplicateElements_targetPresent() {
        int[] arr = {1, 2, 2, 2, 5};
        int target = 2;
        int actual = BiSearch.biSearch(arr, target, 0, arr.length - 1);
        assertTrue(actual >= 1 && actual <= 3);
    }
}
