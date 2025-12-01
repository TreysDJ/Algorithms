package bro.maks.JavaAlgorithmsCourse;

import java.util.Scanner;

public class LIS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = scanner.nextInt();
        int[] arr = new int[max];
        for (int i = 0; i < max; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(LISBottomUp(arr));
    }

    public static int LISBottomUp(int[] arr) {
        int[] lengthArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            lengthArr[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i] && lengthArr[j] + 1 > lengthArr[i] && arr[i] % arr[j] == 0) {
                    lengthArr[i] = lengthArr[j] + 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans = Math.max(ans, lengthArr[i]);
        }
        return ans;
    }
}
