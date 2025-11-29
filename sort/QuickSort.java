package bro.maks.sort;

public class QuickSort implements Sort {
    // привет
    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int index = partition(arr, left, right);
            quickSort(arr, left, index - 1);
            quickSort(arr, index, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int leftIndex = left;
        int rightIndex = right;

        int pivot = arr[left];
        while (leftIndex <= rightIndex) {
            while (arr[leftIndex] < pivot) {
                leftIndex++;
            }
            while (arr[rightIndex] > pivot) {
                rightIndex--;
            }
            if (leftIndex <= rightIndex) {
                swap(arr, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }


}
