package bro.maks.StructureCoruse;

import java.util.Scanner;
import java.util.Stack;

public class Brackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int result = brackets(s);

        if (result == -1) {
            System.out.println("Success");
        } else {
            System.out.println(result);
        }
    }

    public static int brackets(String s) {
        String[] arr = s.split("");
        Stack<String> stack = new Stack<>();
        int current = 0;

        for (int i = 0; i < s.length(); i++) {
            current++;

            if (arr[i].equals("[") || arr[i].equals("(") || arr[i].equals("{")) {
                stack.push(arr[i]);
            } else {
                if (stack.isEmpty()) {
                    return current;
                    
                }
                String top = stack.pop();
                if (top.equals("[") && !(arr[i].equals("]")) || top.equals("{") && !(arr[i].equals("}")) || top.equals("(") && !(arr[i].equals(")"))) {
                    return current;
                }
            }
        }

        if (!(stack.isEmpty())) {
            return current;
        }
        return -1;
    }
}
