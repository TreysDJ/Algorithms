package bro.maks.BasicDataStructuresTest;

import bro.maks.BasicDataStructures.ArrayStack;
import bro.maks.BasicDataStructures.LinkedListStack;
import bro.maks.BasicDataStructures.Stack;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class StackParameterizedTest {

    static Stream<Stack<String>> stack() {
        return Stream.of(
                new ArrayStack<>(16), new LinkedListStack<>());
    }

    @ParameterizedTest()
    @MethodSource("stack")
    void testNewStackIsEmpty(Stack<String> stack) {
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
        assertNull(stack.pop());
        assertNull(stack.peek());
    }

    @ParameterizedTest()
    @MethodSource("stack")
    void testPushElements(Stack<String> stack) {
        stack.push("Макс");
        assertEquals(1, stack.size());
        assertFalse(stack.isEmpty());
        assertEquals("Макс", stack.peek());

        stack.push("Дима");
        assertEquals(2, stack.size());
        assertEquals("Дима", stack.peek());
    }

    @ParameterizedTest()
    @MethodSource("stack")
    void testPopElements(Stack<String> stack) {
        stack.push("Бравл");
        stack.push("Старс");
        stack.push("Топ");

        assertEquals("Топ", stack.pop());
        assertEquals(2, stack.size());

        assertEquals("Старс", stack.pop());
        assertEquals(1, stack.size());

        assertEquals("Бравл", stack.pop());
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
        assertNull(stack.pop());
        assertNull(stack.peek());
    }

    @ParameterizedTest()
    @MethodSource("stack")
    void testPeekElements(Stack<String> stack) {
        stack.push("Бравл");
        stack.push("Старс");

        assertEquals("Старс", stack.peek());
        assertEquals(2, stack.size());
    }

    @ParameterizedTest()
    @MethodSource("stack")
    void testPopFromEmptyStackReturnsNull(Stack<String> stack) {
        assertTrue(stack.isEmpty());
        assertNull(stack.pop());
    }

    @ParameterizedTest()
    @MethodSource("stack")
    void testPeekFromEmptyStackReturnsNull(Stack<String> stack) {
        assertTrue(stack.isEmpty());
        assertNull(stack.peek());
    }

    @ParameterizedTest()
    @MethodSource("stack")
    void testPushNullElement(Stack<String> stack) {
        stack.push("Бравл");
        stack.push(null);
        assertEquals(2, stack.size());
        assertNull(stack.peek());

        assertNull(stack.pop());
        assertEquals(1, stack.size());

        assertEquals("Бравл", stack.pop());
        assertTrue(stack.isEmpty());
    }

    @ParameterizedTest()
    @MethodSource("stack")
    void testManyPushesAndPops(Stack<String> stack) {
        int numElements = 1000;
        for (int i = 0; i < numElements; i++) {
            stack.push("Бравл " + i);
            assertEquals(i + 1, stack.size());
        }

        for (int i = numElements - 1; i >= 0; i--) {
            assertEquals("Бравл " + i, stack.pop());
            assertEquals(i, stack.size());
        }
        assertTrue(stack.isEmpty());
        assertNull(stack.pop());
    }
}