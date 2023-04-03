package part3.chap01.baek11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> qp = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        for (int i = 0; i < n; i++) {
            int[] buffer = new int[2];
            buffer[0] = Integer.parseInt(br.readLine());
            buffer[1] = Math.abs(buffer[0]);

            if (buffer[0] == 0) {
                if (qp.isEmpty()) {
                    System.out.println(0);
                } else {
                    int[] tmp = qp.poll();
                    System.out.println(tmp[0]);
                }
            } else if (buffer[1] > 0) {
                qp.add(buffer);
            }
        }
    }
}