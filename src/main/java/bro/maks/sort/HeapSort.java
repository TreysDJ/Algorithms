package bro.maks.sort;

import bro.maks.JavaAlgorithmsCourse.Heap;

public class HeapSort implements Sort {

    @Override
    public void sort(int[] arr) {
        Heap heap = new Heap(arr.length);
        for (int i = 0; i < arr.length; i++) {
            heap.insert(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = heap.pop();
        }
    }


    public static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
