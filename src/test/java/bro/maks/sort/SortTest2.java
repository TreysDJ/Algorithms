package bro.maks.sort;

import bro.maks.JavaAlgorithmsCourse.HeapSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortTest2 {
    private void testSortAlgorithm(Sort sorter, int[] arrActual, int[] arrExpected) {
        int[] arrActualCopy = Arrays.copyOf(arrActual, arrActual.length);
        sorter.sort(arrActualCopy);
        Assertions.assertArrayEquals(arrExpected, arrActualCopy,
                "сортировка " + sorter.getClass().getSimpleName() + " ошибка ввода: " + Arrays.toString(arrActual));
    }

    private void testAllAlgorithms(int[] arrOriginal, int[] arrExpected) {
        List<Sort> algorithms = new ArrayList<>();
        algorithms.add(new BubbleSort());
        algorithms.add(new SelectionSort());
        algorithms.add(new InsertionSort());
        algorithms.add(new MergeSort());
        algorithms.add(new QuickSort());
        algorithms.add(new NotEqualsSort());
        algorithms.add(new HeapSort());
        for (Sort algorithm : algorithms) {
            testSortAlgorithm(algorithm, arrOriginal, arrExpected);
        }
    }

    @Test
    void testBaseTypicalCase() {
        int[] arrOriginal = {5, 7, 3, 8, 1, 5};
        int[] arrExpected = {1, 3, 5, 5, 7, 8};
        testAllAlgorithms(arrOriginal, arrExpected);
    }


    @Test
    void testArrayWithEqualElements() {
        int[] arrOriginal = {5, 5, 5, 5, 5};
        int[] arrExpected = {5, 5, 5, 5, 5};

        testAllAlgorithms(arrOriginal, arrExpected);
    }

    @Test
    void testAlreadySortedArray() {
        int[] arrOriginal = {1, 2, 3, 4, 5};
        int[] arrExpected = {1, 2, 3, 4, 5};

        testAllAlgorithms(arrOriginal, arrExpected);
    }

    @Test
    void testReverseSortedArray() {
        int[] arrOriginal = {5, 4, 3, 2, 1};
        int[] arrExpected = {1, 2, 3, 4, 5};

        testAllAlgorithms(arrOriginal, arrExpected);
    }

    @Test
    void testSingleElementArray() {
        int[] arrOriginal = {5};
        int[] arrExpected = {5};

        testAllAlgorithms(arrOriginal, arrExpected);
    }

    @Test
    void testEmptyArray() {
        int[] arrOriginal = {};
        int[] arrExpected = {};

        testAllAlgorithms(arrOriginal, arrExpected);
    }
}
