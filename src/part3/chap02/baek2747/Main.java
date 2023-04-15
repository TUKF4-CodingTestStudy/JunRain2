package part3.chap02.baek2747;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 재귀함수 쓰면 시간초과 뜸.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(fibonacci(n));


    }

    static int fibonacci(int n){
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n - 2);
    }
}
