package part3.chap02.baek11650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] tmp = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            list.add(tmp);
        }

        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else return o1[0] - o2[0];
            }
        });

        for (int[] ints : list) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }
}
