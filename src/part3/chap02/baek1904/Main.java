package part3.chap02.baek1904;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int[] tmp = new int[1000001];
        tmp[1] = 1;
        tmp[2] = 2;

        for (int i = 3; i <= n; i++) {
            tmp[i] = (tmp[i - 1] + tmp[i - 2])%15746;
        }
        System.out.println(tmp[n]);
    }
}
