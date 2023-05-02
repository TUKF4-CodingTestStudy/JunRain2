package part3.chap02.baek1766;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[1] - o2[1];
//            }
//        });
//
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//
//        for (int i = 0; i < m; i++) {
//            st = new StringTokenizer(br.readLine());
//            int[] tmp = new int[2];
//            tmp[0] = Integer.parseInt(st.nextToken());
//            tmp[1] = Integer.parseInt(st.nextToken());
//
//            if (tmp[0] < tmp[1]) {
//                pq.add(tmp);
//            }
//        }
//
//        LinkedHashSet<Integer> result = new LinkedHashSet<>();
//
//        for (int i = 1; i <= n; i++) {
//            if (!pq.isEmpty()) {
//                if (pq.peek()[1] == i) {
//                    int[] num = pq.poll();
//                    result.add(num[0]);
//                    result.add(num[1]);
//                } else {
//                    result.add(i);
//                }
//            } else {
//                result.add(i);
//            }
//        }
//        Iterator iterator = result.iterator();
//        while (iterator.hasNext()) {
//            System.out.printf(iterator.next() + " ");
//        }
//    }
//}
//

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] indegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indegree = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            indegree[y]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                pq.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            sb.append(cur).append(" ");

            for (int next : graph.get(cur)) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    pq.offer(next);
                }
            }
        }

        System.out.println(sb);
    }
}
