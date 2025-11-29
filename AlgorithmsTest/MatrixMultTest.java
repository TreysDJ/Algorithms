package bro.maks.Algorithms;

import bro.maks.JavaAlgorithmsCourse.MatrixMult;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MatrixMultTest {
    // привет

    @Test
    void testOneMatrix() {
        int[] p = {10, 20};
        assertEquals(0, MatrixMult.matrixMult(p));
    }

    @Test
    void testTwoMatrices() {
        int[] p = {10, 20, 30};
        assertEquals(6000, MatrixMult.matrixMult(p));
    }

    @Test
    void testThreeMatrices() {
        int[] p = {10, 20, 5, 30};
        assertEquals(2500, MatrixMult.matrixMult(p));
    }

    @Test
    void testClassicBookExample_FourMatrices() {
        int[] p = {40, 20, 30, 10, 30};
        assertEquals(26000, MatrixMult.matrixMult(p));
    }

    @Test
    void testComplexExample_CormenBook() {
        int[] p = {30, 35, 15, 5, 10, 20, 25};
        assertEquals(15125, MatrixMult.matrixMult(p));
    }

    @Test
    void testWithLargeNumbers() {
        int[] p = {100, 200, 300, 50};
        assertEquals(4000000, MatrixMult.matrixMult(p));
    }
}
