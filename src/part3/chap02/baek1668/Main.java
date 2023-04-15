package part3.chap02.baek1668;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> list = new LinkedList<>();

        while (n-- > 0) {
            list.add(Integer.parseInt(br.readLine()));
        }
        int tmp = 0;
        int buffer = 0;
        for (int i : list) {
            if (buffer < i) {
                buffer = i;
                tmp++;
            }
        }
        buffer = 0;
        int tmp2 = 0;
        Collections.reverse(list);
        for (int i : list) {
            if (buffer < i) {
                buffer = i;
                tmp2++;
            }
        }
        System.out.println(tmp);
        System.out.println(tmp2);
    }
}
