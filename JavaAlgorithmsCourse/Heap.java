package bro.maks.JavaAlgorithmsCourse;

import java.util.Arrays;
import java.util.Scanner;

public class Heap {
    private int[] heap;
    private int size;

    public Heap(int initialCapacity) {
        if (initialCapacity <= 0) {
            return;
        }
        this.heap = new int[initialCapacity];
        this.size = 0;
    }

    private void swap(int indexOne, int indexTwo) {
        int temp = this.heap[indexOne];
        this.heap[indexOne] = this.heap[indexTwo];
        this.heap[indexTwo] = temp;
    }

    public void insert(int item) {
        multiCapacity();
        this.heap[this.size] = item;
        this.size++;
        siftUp();
    }

    public int pop() {
        if (this.size == 0) {
            return -1;
        }
        int item = this.heap[0];
        this.heap[0] = this.heap[this.size - 1];
        this.size--;
        siftDown();
        return item;
    }

    public int top() {
        if (this.size == 0) {
            return -1;
        }
        return this.heap[0];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private void siftUp() {
        int index = this.size - 1;
        while (index > 0 && this.heap[(index - 1) / 2] > this.heap[index]) {
            int parentIndex = (index - 1) / 2;
            swap(parentIndex, index);
            index = parentIndex;
        }
    }

    private void siftDown() {
        int index = 0;
        while ((2 * index + 1) < this.size) {
            int leftIndex = 2 * index + 1;
            int rightIndex = 2 * index + 2;

            if (rightIndex < this.size && this.heap[rightIndex] < this.heap[leftIndex]) {
                leftIndex = rightIndex;
            }

            if (this.heap[index] < this.heap[leftIndex]) {
                break;
            } else {
                swap(index, leftIndex);
            }
            index = leftIndex;
        }
    }

    private void multiCapacity() {
        if (this.size == this.heap.length) {
            this.heap = Arrays.copyOf(this.heap, this.heap.length * 2);
        }
    }

    public String toString() {
        int[] activeHeap = Arrays.copyOf(heap, size);
        return Arrays.toString(activeHeap);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        Heap heap = new Heap(length);
        for (int i = 0; i < length; i++) {
            int value = scanner.nextInt();
            heap.insert(value);
        }
        System.out.println(heap);
        System.out.println(heap.top());
        while (!heap.isEmpty()) {
            System.out.print(heap.pop() + " ");
        }
    }
}
