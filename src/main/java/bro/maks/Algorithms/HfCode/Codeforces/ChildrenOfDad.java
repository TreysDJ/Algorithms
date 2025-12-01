package bro.maks.Algorithms.HfCode.Codeforces;

import java.util.Scanner;

public class ChildrenOfDad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // количество дочерей
        int[] children = new int[n];
        int m = scanner.nextInt(); // количество желаний
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt(); // кто хочет
            int y = scanner.nextInt(); // не меньше чем у кого
        }

        int k = scanner.nextInt(); // количество коробок в тц
        int[] surprise = new int[k];
        for (int i = 0; i < k; i++) {
            surprise[i] = scanner.nextInt();
        }
        
    }
}
