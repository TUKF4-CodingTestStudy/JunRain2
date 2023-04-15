package part3.chap02.baek1236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        char[][] castle = new char[y][x];

        for (int i = 0; i < y; i++) {
            String s = br.readLine();
            castle[i] = s.toCharArray();
        }

        boolean[] yBoolean = new boolean[y];
        boolean[] xBoolean = new boolean[x];

        Arrays.fill(xBoolean, false);
        Arrays.fill(yBoolean, false);


        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (castle[i][j] == 'X') {
                    yBoolean[i] = true;
                    xBoolean[j] = true;
                }
            }
        }
        int xCount = 0;
        int yCount = 0;
        for (int i = 0; i < y; i++){
            if (!yBoolean[i]) {
                yCount++;
            }
        }
        for (int i = 0; i < x; i++){
            if (!xBoolean[i]) {
                xCount++;
            }
        }
        System.out.println(Math.max(yCount,xCount));
    }
}
