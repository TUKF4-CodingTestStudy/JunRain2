package part3.chap02.baek1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> qp = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            int tmp = Integer.parseInt(br.readLine());
            if (tmp == 0) {
                if (qp.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(qp.poll());
                }
            } else {
                qp.add(tmp);
            }
        }
    }
}
