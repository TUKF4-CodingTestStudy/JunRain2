package part3.chap02.baek11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] ints = new int[n];

        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[n];
        Arrays.fill(result, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (ints[j] < ints[i]) {
                    result[i] = Math.max(result[i], result[j]+1);
                }
            }
        }


        System.out.println(Arrays.stream(result).max().getAsInt());
    }
}

