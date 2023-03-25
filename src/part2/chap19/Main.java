package part2.chap19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        final int N = 5;
        List<Integer> list = new ArrayList<>(List.of(3, 1, 4, 3, 2));
        Collections.sort(list);

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i+1; j++) {
                sum += list.get(j);
            }
        }
        System.out.println("sum = " + sum);
    }
}
