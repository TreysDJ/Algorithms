package bro.maks.JavaAlgorithmsCourse;
import java.util.HashMap;

public class MemoiZationFibonachi {
    // привет
    public HashMap<Integer, Integer> fibonacheri = new HashMap<>();
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
        if (fibonacheri.containsKey(number)) {
            return fibonacheri.get(number);
        }
        int result = fibonachi(number - 1) + fibonachi(number - 2);
        fibonacheri.put(number, result);
        return result;
    }
}
