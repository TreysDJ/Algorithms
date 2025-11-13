package bro.maks.JavaAlgorithmsCourse;

import java.util.Scanner;

public class MatrixMult {
    // привет
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] arr = new int[number + 1];
        for (int i = 0; i <= number; i++) {
            arr[i] = scanner.nextInt();
        }
        int result = matrixMult(arr);
        System.out.println(result);
    }

    public static int matrixMult(int[] p) {
        int n = p.length - 1;

        int[][] D = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    D[i][j] = 0;
                } else {
                    D[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int s = 1; s < n; s++) {
            for (int i = 1; i <= n - s; i++) {
                int j = i + s;
                for (int k = i; k < j; k++) {
                    int cost = D[i][k] + D[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (cost < D[i][j]) {
                        D[i][j] = cost;
                    }
                }
            }
        }
        return D[1][n];
    }
}
