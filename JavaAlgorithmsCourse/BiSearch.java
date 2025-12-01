package bro.maks.JavaAlgorithmsCourse;

import java.util.Scanner;

public class BiSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int target = scanner.nextInt();

        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = scanner.nextInt();
        }
        biSearch(arr, target, 0, arr.length - 1);
    }
    public static int biSearch(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return biSearch(arr, target, mid + 1, right);
        } else {
            return biSearch(arr, target, left, mid - 1);
        }
    }
}
