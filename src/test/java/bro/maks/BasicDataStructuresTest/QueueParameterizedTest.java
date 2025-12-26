package bro.maks.BasicDataStructuresTest;

import bro.maks.BasicDataStructures.ArrayQueue;
import bro.maks.BasicDataStructures.LinkedQueue;
import bro.maks.BasicDataStructures.Queue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class QueueParameterizedTest {
    static Stream<Queue<String>> queue() {
        return Stream.of(new ArrayQueue<>(), new LinkedQueue<>());
    }

    @ParameterizedTest()
    @MethodSource("queue")
    void testNewQueueIsEmpty(Queue<String> queue) {
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
        assertNull(queue.pop());
        assertNull(queue.peek());
    }

    @ParameterizedTest()
    @MethodSource("queue")
    void testPushElements(Queue<String> queue) {
        queue.push("Дима");
        assertEquals(1, queue.size());
        assertFalse(queue.isEmpty());
        assertEquals("Дима", queue.peek());

        queue.push("Дима");
        assertEquals(2, queue.size());
        assertEquals("Дима", queue.peek());
    }

    @ParameterizedTest()
    @MethodSource("queue")
    void testPopElements(Queue<String> queue) {
        queue.push("Бравл");
        queue.push("Старс");

        assertEquals("Бравл", queue.pop());
        assertEquals(1, queue.size());

        assertEquals("Старс", queue.pop());
        assertEquals(0, queue.size());

        assertTrue(queue.isEmpty());

        assertNull(queue.pop());
        assertNull(queue.peek());
    }

    @ParameterizedTest()
    @MethodSource("queue")
    void testPeekElements(Queue<String> queue) {
        queue.push("Макс");
        queue.push("Дима");

        assertEquals("Макс", queue.peek());
        assertEquals(2, queue.size());

        queue.pop();
        assertEquals("Дима", queue.peek());
    }

    @ParameterizedTest()
    @MethodSource("queue")
    void testPopFromEmptyQueueReturnsNull(Queue<String> queue) {
        assertTrue(queue.isEmpty());
        assertNull(queue.pop());
    }

    @ParameterizedTest()
    @MethodSource("queue")
    void testPeekFromEmptyQueueReturnsNull(Queue<String> queue) {
        assertTrue(queue.isEmpty());
        assertNull(queue.peek());
    }

    @ParameterizedTest()
    @MethodSource("queue")
    void testManyPushesAndPops(Queue<String> queue) {
        int numElements = 10;
        for (int i = 0; i < numElements; i++) {
            queue.push("Бравл " + i);
            assertEquals(i + 1, queue.size());
        }

        for (int i = 0; i < numElements; i++) {
            assertEquals("Бравл " + i, queue.pop());
            assertEquals(numElements - 1 - i, queue.size());
        }
        assertTrue(queue.isEmpty());
        assertNull(queue.pop());
    }

    @Test
    void testWhenSizeIsCrowdedArrayQueue() {
        ArrayQueue<String> queue = new ArrayQueue();

        Assertions.assertTrue(queue.isEmpty());
        queue.push("Бравл");
        queue.push("Старс");
        queue.push("Топ");
        queue.push("Или нет?");

        Assertions.assertEquals(4, queue.size());
        queue.push("Или всё таки да...");
        Assertions.assertFalse(queue.isEmpty());
        Assertions.assertEquals(5, queue.size());

        Assertions.assertEquals("Бравл", queue.peek());
        Assertions.assertEquals("Бравл", queue.pop());;
        Assertions.assertEquals(4, queue.size());
    }
}
