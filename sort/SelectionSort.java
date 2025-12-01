package bro.maks.sort;

class SelectionSort implements Sort {
    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int smallestIndex = smallestIndexOf(arr, i);
            int current = arr[i];
            if (smallestIndex != i) {
                arr[i] = arr[smallestIndex];
                arr[smallestIndex] = current;
            }
        }
    }

    public int smallestIndexOf(int[] arr, int from) {
        int smallest = arr[from];
        int indexOf = from;
        for (int i = from + 1; i < arr.length; i++) {
            if (smallest > arr[i]) {
                smallest = arr[i];
                indexOf = i;
            }
        }
        return indexOf;
    }
}
