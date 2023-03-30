package part3.chap01.baek1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        LinkedList<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        for (int target : list) {
            int index = queue.indexOf(target);
            if (index <= queue.size() / 2) {
                for (int j = 0; j < index; j++) {
                    int x = queue.removeFirst();
                    queue.addLast(x);
                    count++;
                }
            }else {
                for (int j = 0; j < queue.size() - index; j++) {
                    int x = queue.removeLast();
                    queue.addFirst(x);
                    count++;
                }
            }
            queue.remove();
        }
        System.out.println(count);

    }
}
