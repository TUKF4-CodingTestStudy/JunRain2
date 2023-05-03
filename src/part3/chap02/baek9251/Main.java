package part3.chap02.baek9251;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp = br.readLine();
        char[] x = tmp.toCharArray();
        tmp = br.readLine();
        char[] y = tmp.toCharArray();

        int[][] dp = new int[x.length + 1][y.length + 1];
        for (int i = 0; i <= x.length; i++) {
            Arrays.fill(dp[i], 0);
        }

        for (int i = 1; i <= x.length; i++) {
            for (int j = 1; j <= y.length; j++) {
                if (x[i-1] == y[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else if (x[i-1] != y[j-1]) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        System.out.println(dp[x.length][y.length]);
    }
}

// DP 문제를 풀기 위해서는 표를 이용한 점화식이 중요!!!