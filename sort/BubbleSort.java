package bro.maks.sort;

public class BubbleSort implements Sort {
    // привет
    @Override
    public void sort(int[] arr) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < arr[i - 1]) {
                    int currentIndex = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = currentIndex;
                    isSorted = false;
                }
            }
        }
    }
}
