package bro.maks.Algorithms;

import bro.maks.JavaAlgorithmsCourse.HeapSort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;

public class HeapSortTest {
    // привет

    @Test
    void testEmptyArray() {
        int[] arr = {};
        HeapSort sorter = new HeapSort();
        sorter.sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void testSingleElementArray() {
        int[] arr = {5};
        HeapSort sorter = new HeapSort();
        sorter.sort(arr);
        assertArrayEquals(new int[]{5}, arr);
    }

    @Test
    void testAlreadySortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        HeapSort sorter = new HeapSort();
        sorter.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testReverseSortedArray() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        HeapSort sorter = new HeapSort();
        sorter.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testUnsortedArray() {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6};
        int[] expected = {1, 1, 2, 3, 4, 5, 6, 9};
        HeapSort sorter = new HeapSort();
        sorter.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testArrayWithDuplicates() {
        int[] arr = {5, 2, 8, 2, 5, 1, 8};
        int[] expected = {1, 2, 2, 5, 5, 8, 8};
        HeapSort sorter = new HeapSort();
        sorter.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testArrayWithNegativeNumbers() {
        int[] arr = {-3, 0, -1, 2, -5};
        int[] expected = {-5, -3, -1, 0, 2};
        HeapSort sorter = new HeapSort();
        sorter.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testLargeRandomArray() {
        int size = 1000;
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(10000);
        }

        int[] expected = Arrays.copyOf(arr, size);
        Arrays.sort(expected);

        HeapSort sorter = new HeapSort();
        sorter.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testAllSameElementsArray() {
        int[] arr = {7, 7, 7, 7, 7};
        int[] expected = {7, 7, 7, 7, 7};
        HeapSort sorter = new HeapSort();
        sorter.sort(arr);
        assertArrayEquals(expected, arr);
    }
}
