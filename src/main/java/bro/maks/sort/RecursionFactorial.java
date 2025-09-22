package bro.maks.sort;

public class RecursionFactorial {
    public int factorial(int n) {
        if (n == 1 || n == 0) {
            return 1; // простой случай
        }
        if (n > 0) {
            return n * factorial(n - 1); // сведение к простому случаю
        }
        return -1;
    }
}
