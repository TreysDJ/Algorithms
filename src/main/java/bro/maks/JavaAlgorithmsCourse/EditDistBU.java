package bro.maks.JavaAlgorithmsCourse;

import java.util.Scanner;

public class EditDistBU {
    // привет
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        System.out.println(edit(a, b));
    }

    public static int edit(String a, String b) {
        int n = a.length();
        int m = b.length();

        int[][] matrix = new int[n + 1][m + 1];
        int cost;

        for (int i = 0; i <= n; i++) {
            matrix[i][0]= i;
        }
        for (int j = 0; j <= m; j++) {
            matrix[0][j] = j;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    cost = 0;
                } else {
                    cost = 1;
                }
                matrix[i][j] = Math.min(matrix[i - 1][j] + 1, matrix[i][j - 1] + 1);
                matrix[i][j] = Math.min(matrix[i][j],matrix[i - 1][j - 1] + cost);
            }
        }
        return matrix[n][m];
    }
}
