package bro.maks.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SortTest {
    @Test
    void sortBubbleDefaultTest() {
        BubbleSort bubble = new BubbleSort();
        int[] arrActual = {5, 7, 3, 8, 1, 5,};
        int[] arrExcepted = {1, 3, 5, 5, 7, 8};
        bubble.sort(arrActual);
        Assertions.assertArrayEquals(arrExcepted, arrActual);
    }

    @Test
    void sortSelectionDefaultTest() {
        SelectionSort selection = new SelectionSort();
        int[] arrActual = {5, 7, 3, 8, 1, 5,};
        int[] arrExpeced = {1, 3, 5, 5, 7, 8};
        selection.sort(arrActual);
        Assertions.assertArrayEquals(arrExpeced, arrActual);
    }

    @Test
    void sortInsertionDefaultTest() {
        InsertionSort insertion = new InsertionSort();
        int[] arrActual = {5, 7, 3, 8, 1, 5,};
        int[] arrExpeced = {1, 3, 5, 5, 7, 8};
        insertion.sort(arrActual);
        Assertions.assertArrayEquals(arrExpeced, arrActual);
    }

    @Test
    void sortBubbleEqualsTest() {
        BubbleSort bubble = new BubbleSort();
        int[] arrActual = {5, 5, 5, 5, 5};
        int[] arrExpeced = {5, 5, 5, 5, 5};
        bubble.sort(arrActual);
        Assertions.assertArrayEquals(arrExpeced, arrActual);
    }

    @Test
    void sortSelectionEqualsTest() {
        SelectionSort selection = new SelectionSort();
        int[] arrActual = {5, 5, 5, 5, 5};
        int[] arrExpeced = {5, 5, 5, 5, 5};
        selection.sort(arrActual);
        Assertions.assertArrayEquals(arrExpeced, arrActual);
    }

    @Test
    void sortInsertionEqualsTest() {
        InsertionSort insertion = new InsertionSort();
        int[] arrActual = {5, 5, 5, 5, 5};
        int[] arrExpeced = {5, 5, 5, 5, 5};
        insertion.sort(arrActual);
        Assertions.assertArrayEquals(arrExpeced, arrActual);
    }

    @Test
    void sortBubbleAlreadyTest() {
        BubbleSort bubble = new BubbleSort();
        int[] arrActual = {1, 2, 3, 4, 5};
        int[] arrExpeced = {1, 2, 3, 4, 5};
        bubble.sort(arrActual);
        Assertions.assertArrayEquals(arrExpeced, arrActual);
    }

    @Test
    void sortSelectionAlreadyTest() {
        SelectionSort selection = new SelectionSort();
        int[] arrActual = {1, 2, 3, 4, 5};
        int[] arrExpeced = {1, 2, 3, 4, 5};
        selection.sort(arrActual);
        Assertions.assertArrayEquals(arrExpeced, arrActual);
    }

    @Test
    void sortInsertionAlreadyTest() {
        InsertionSort insertion = new InsertionSort();
        int[] arrActual = {1, 2, 3, 4, 5};
        int[] arrExpeced = {1, 2, 3, 4, 5};
        insertion.sort(arrActual);
        Assertions.assertArrayEquals(arrExpeced, arrActual);
    }

    @Test
    void sortBubbleReturnTest() {
        BubbleSort bubble = new BubbleSort();
        int[] arrActual = {5, 4, 3, 2, 1};
        int[] arrExpeced = {1, 2, 3, 4, 5};
        bubble.sort(arrActual);
        Assertions.assertArrayEquals(arrExpeced, arrActual);
    }

    @Test
    void sortSelectionReturnTest() {
        SelectionSort selection = new SelectionSort();
        int[] arrActual = {5, 4, 3, 2, 1};
        int[] arrExpeced = {1, 2, 3, 4, 5};
        selection.sort(arrActual);
        Assertions.assertArrayEquals(arrExpeced, arrActual);
    }

    @Test
    void sortInsertionReturnTest() {
        InsertionSort insertion = new InsertionSort();
        int[] arrActual = {5, 4, 3, 2, 1};
        int[] arrExpeced = {1, 2, 3, 4, 5};
        insertion.sort(arrActual);
        Assertions.assertArrayEquals(arrExpeced, arrActual);
    }

    @Test
    void sortBubbleOneTest() {
        BubbleSort bubble = new BubbleSort();
        int[] arrActual = {5};
        int[] arrExpeced = {5};
        bubble.sort(arrActual);
        Assertions.assertArrayEquals(arrExpeced, arrActual);
    }

    @Test
    void sortSelectionOneTest() {
        SelectionSort selection = new SelectionSort();
        int[] arrActual = {5};
        int[] arrExpeced = {5};
        selection.sort(arrActual);
        Assertions.assertArrayEquals(arrExpeced, arrActual);
    }

    @Test
    void sortInsertionOneTest() {
        InsertionSort insertion = new InsertionSort();
        int[] arrActual = {5};
        int[] arrExpeced = {5};
        insertion.sort(arrActual);
        Assertions.assertArrayEquals(arrExpeced, arrActual);
    }

    @Test
    void sortBubbleEmptyTest() {
        BubbleSort bubble = new BubbleSort();
        int[] arrActual = {};
        int[] arrExpeced = {};
        bubble.sort(arrActual);
        Assertions.assertArrayEquals(arrExpeced, arrActual);
    }

    @Test
    void sortSelectionEmptyTest() {
        SelectionSort selection = new SelectionSort();
        int[] arrActual = {};
        int[] arrExpeced = {};
        selection.sort(arrActual);
        Assertions.assertArrayEquals(arrExpeced, arrActual);
    }

    @Test
    void sortInsertionEmptyTest() {
        InsertionSort insertion = new InsertionSort();
        int[] arrActual = {};
        int[] arrExpeced = {};
        insertion.sort(arrActual);
        Assertions.assertArrayEquals(arrExpeced, arrActual);
    }

    @Test
    void factorialDefaultTest() {
        RecursionFactorial fac = new RecursionFactorial();
        int factorial = fac.factorial(7);
        Assertions.assertEquals(5040, factorial);
    }

    @Test
    void factorialNullTest() {
        RecursionFactorial fac = new RecursionFactorial();
        int factorial = fac.factorial(0);
        Assertions.assertEquals(1, factorial);
    }

    @Test
    void factorialOneTest() {
        RecursionFactorial fac = new RecursionFactorial();
        int factorial = fac.factorial(1);
        Assertions.assertEquals(1, factorial);
    }

    @Test
    void factorialLessTest() {
        RecursionFactorial fac = new RecursionFactorial();
        int factorial = fac.factorial(-5);
        Assertions.assertEquals(-1, factorial);
    }

    @Test
    void recursionFibonachiDefaultTest() {
        RecursionFibonachi fib = new RecursionFibonachi();
        Assertions.assertEquals(1, fib.fibonachi(2));
        Assertions.assertEquals(2, fib.fibonachi(3));
        Assertions.assertEquals(3, fib.fibonachi(4));
        Assertions.assertEquals(5, fib.fibonachi(5));
    }

    @Test
    void recursionFibonachiBaseTest() {
        RecursionFibonachi fib = new RecursionFibonachi();
        Assertions.assertEquals(0, fib.fibonachi(0));
        Assertions.assertEquals(1, fib.fibonachi(1));
    }

    @Test
    void recursionFibonachiNegativeTest() {
        RecursionFibonachi fib = new RecursionFibonachi();
        Assertions.assertEquals(-1, fib.fibonachi(-1));
        Assertions.assertEquals(-1, fib.fibonachi(-5));
    }

    @Test
    void fibonachiDefaultTest() {
        FibonachiNoRecursion fib = new FibonachiNoRecursion();
        Assertions.assertEquals(1, fib.fibonachi(2));
        Assertions.assertEquals(2, fib.fibonachi(3));
        Assertions.assertEquals(3, fib.fibonachi(4));
        Assertions.assertEquals(5, fib.fibonachi(5));
    }

    @Test
    void fibonachiBaseTest() {
        FibonachiNoRecursion fib = new FibonachiNoRecursion();
        Assertions.assertEquals(0, fib.fibonachi(0));
        Assertions.assertEquals(1, fib.fibonachi(1));
    }

    @Test
    void fibonachiNegativeTest() {
        FibonachiNoRecursion fib = new FibonachiNoRecursion();
        Assertions.assertEquals(-1, fib.fibonachi(-1));
        Assertions.assertEquals(-1, fib.fibonachi(-5));
    }

    @Test
    void memoFibonachiDefaultTest() {
        MemoiZationFibonachi fib = new MemoiZationFibonachi();
        Assertions.assertEquals(1, fib.fibonachi(2));
        Assertions.assertEquals(2, fib.fibonachi(3));
        Assertions.assertEquals(3, fib.fibonachi(4));
        Assertions.assertEquals(5, fib.fibonachi(5));
    }

    @Test
    void memoFibonachiBaseTest() {
        MemoiZationFibonachi fib = new MemoiZationFibonachi();
        Assertions.assertEquals(0, fib.fibonachi(0));
        Assertions.assertEquals(1, fib.fibonachi(1));
    }

    @Test
    void memoFibonachiNegativeTest() {
        MemoiZationFibonachi fib = new MemoiZationFibonachi();
        Assertions.assertEquals(-1, fib.fibonachi(-1));
        Assertions.assertEquals(-1, fib.fibonachi(-5));
    }

}

