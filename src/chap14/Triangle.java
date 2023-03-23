package chap14;

import java.util.Arrays;

public class Triangle {

    public static void main(String[] args) {
        System.out.println(triangle(12));
    }
    static int triangle(int n) {
        int[] num = new int[101];
        Arrays.fill(num, 0);

        num[1] = 1;
        num[2] = 1;
        num[3] = 1;

        for (int i = 4; i <= 100; i++) {
            num[i] = num[i - 2] + num[i - 3];
        }
        return num[n];
    }
}
