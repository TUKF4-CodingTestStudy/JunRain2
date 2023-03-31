package part3.chap01.baek13335;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < w; i++) {
            bridge.add(0);
        }
        int count = 0;
        int weight = 0;

        while (!bridge.isEmpty()) {
            count++;
            weight -= bridge.poll();
            if (!queue.isEmpty()) {
                if (queue.peek() + weight <= l) {
                    weight += queue.peek();
                    bridge.offer(queue.poll());
                } else bridge.offer(0);
            }
        }
        System.out.println(count);
    }
}
