package part3.chap01.baek10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                if (stack.isEmpty()) {
                    continue;
                }
                stack.pop();
            } else stack.push(n);
        }
        int result = stack.stream().reduce(0, Integer::sum);
        System.out.println(result);
    }
}
