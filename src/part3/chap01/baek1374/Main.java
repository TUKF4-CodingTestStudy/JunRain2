package part3.chap01.baek1374;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> qp = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<int[]> lastQ = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] time = new int[2];
            st.nextToken();
            time[0] = Integer.parseInt(st.nextToken());
            time[1] = Integer.parseInt(st.nextToken());
            qp.add(time);
        }

        lastQ.add(qp.poll());
        int room = 0;
        while (!qp.isEmpty()) {
            if (!lastQ.isEmpty()) {
                if (qp.peek()[0] >= lastQ.peek()[1]) {
                    lastQ.poll();
                    lastQ.add(qp.poll());
                } else  {
                    lastQ.add(qp.poll());
                    room++;
                }
            }
        }
        System.out.println(room);
    }
}
