package chap14;

import java.util.Arrays;

public class Tiling {
    public static void main(String[] args) {
        System.out.println(tile(4));
    }
    static int tile(int n) {
        int[] num = new int[1001];
        Arrays.fill(num, 0);

        num[1] = 1;
        num[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            num[i] = (num[i - 1] + num[i - 2]);
        }
        return num[n]%1007;
    }


}
