package part3.chap02.baek1495;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arrays = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arrays[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], false);
        }
        dp[0][s] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (!dp[i-1][j]) {
                    continue;
                } if (j - arrays[i - 1] >= 0) {
                    dp[i][j - arrays[i - 1]] = true;
                } if (j + arrays[i - 1] <= m) {
                    dp[i][j + arrays[i - 1]] = true;
                }
            }
        }

        int result = -1;
        for (int i = m; i >= 0; i--) {
            if (dp[n][i]) {
                result = i;
                break;
            }
        }

        System.out.println(result);

    }
}

//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int s = sc.nextInt();
//        int m = sc.nextInt();
//        int[] array = new int[n];
//        for (int i = 0; i < n; i++) {
//            array[i] = sc.nextInt();
//        }
//        int[][] dp = new int[n+1][m+1];
//        dp[0][s] = 1;
//        for (int i = 1; i <= n; i++) {
//            for (int j = 0; j <= m; j++) {
//                if (dp[i-1][j] == 0) continue;
//                if (j - array[i-1] >= 0) {
//                    dp[i][j - array[i-1]] = 1;
//                }
//                if (j + array[i-1] <= m) {
//                    dp[i][j + array[i-1]] = 1;
//                }
//            }
//        }
//        int result = -1;
//        for (int i = m; i >= 0; i--) {
//            if (dp[n][i] == 1) {
//                result = i;
//                break;
//            }
//        }
//        System.out.println(result);
//    }
//}
