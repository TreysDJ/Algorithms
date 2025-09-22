package bro.maks.sort;

public class RecursionFibonachi {
    public int fibonachi(int number) {
        if (number < 0) {
            return -1;
        }
        if (number == 0) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }
        return fibonachi(number - 1) + fibonachi(number - 2);
    }
}
