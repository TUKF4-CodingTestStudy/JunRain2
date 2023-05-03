package part3.chap01.beak2346;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<int[]> list = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            list.add(new int[] {Integer.parseInt(st.nextToken()), i+1});

        }
        int[] buffer = list.removeFirst();
        sb.append(buffer[1]+" ");
        while (!list.isEmpty()) {
            if (buffer[0] < 0) {
                for (int j = 0; j < Math.abs(buffer[0]); j++) {
                    list.addFirst(list.removeLast());
                }
            } else {
                for (int j = 0; j < buffer[0]-1; j++) {
                    list.addLast(list.removeFirst());
                }
            }
            buffer = list.removeFirst();
            sb.append(buffer[1]+" ");
        }
            System.out.print(sb);
    }
}
