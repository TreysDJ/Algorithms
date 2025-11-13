package bro.maks.sort;

public class NotEqualsSort implements Sort {
    // привет
    public void sort(int[] arr) {
        int maxValue = 11;
        int[] count = new int[maxValue];

        for (int k : arr) {
            count[k] = count[k] + 1;
        }
        int currentIndex = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                arr[currentIndex] = i;
                currentIndex++;
            }
        }
    }
}
