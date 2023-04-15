package part3.chap02.baek1568;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int cnt = 0;
        int tmp = 1;

        while (n > 0) {
            if (n < tmp) {
                tmp = 1;
            }
            n -= tmp;
            tmp++;
            cnt++;
        }

        System.out.println(cnt);
    }
}
