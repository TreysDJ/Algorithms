package bro.maks.JavaAlgorithmsCourse;

import java.util.Scanner;

public class BackPack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt();
        int n = scanner.nextInt();

        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        int result = take(w, weights);
        System.out.println(result);
    }

    public static int take(int capacity, int[] weights) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j >= weights[i - 1]) {
                    int dontTake = dp[i - 1][j];
                    int take = weights[i - 1] + dp[i - 1][j - weights[i - 1]];
                    dp[i][j] = Math.max(dontTake, take);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][capacity];
    }
}
