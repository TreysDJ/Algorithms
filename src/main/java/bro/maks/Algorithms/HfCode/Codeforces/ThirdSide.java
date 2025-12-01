package bro.maks.Algorithms.HfCode.Codeforces;

import java.util.Random;
import java.util.Scanner;

public class ThirdSide {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int i = random.nextInt(0, n - 1);
        int j = random.nextInt(0, n - 1);

        int x = a[i] + a[j] - 1;


    }
}
