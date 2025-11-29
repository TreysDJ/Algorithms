package bro.maks.sort;

public class InsertionSort implements Sort {
    // привет
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int index = i;
            while (index > 0 && arr[index - 1] > current) {
                arr[index] = arr[index - 1];
                index--;
            }
            arr[index] = current;
        }
    }
}
