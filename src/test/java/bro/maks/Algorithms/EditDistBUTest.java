package bro.maks.Algorithms;

import bro.maks.JavaAlgorithmsCourse.EditDistBU;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EditDistBUTest {
    // привет

    @Test
    void testBothStringsEmpty() {
        assertEquals(0, EditDistBU.edit("", ""));
    }

    @Test
    void testFirstStringEmpty() {
        assertEquals(5, EditDistBU.edit("", "hello"));
    }

    @Test
    void testSecondStringEmpty() {
        assertEquals(5, EditDistBU.edit("world", ""));
    }

    @Test
    void testIdenticalStrings() {
        assertEquals(0, EditDistBU.edit("test", "test"));
    }
}