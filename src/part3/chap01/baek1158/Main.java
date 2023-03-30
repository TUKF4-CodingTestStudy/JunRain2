package part3.chap01.baek1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        while (!list.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                int x = list.removeFirst();
                list.addLast(x);
            }
            result.add(list.pop());
        }
        System.out.print("<");
        for (int i = 0; i < result.size(); i++) {
            if (i < result.size() - 1) {
                System.out.print(result.get(i) + ", ");
            } else System.out.print(result.get(i));
        }
        System.out.print(">");
    }
}
