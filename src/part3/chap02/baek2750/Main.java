package part3.chap02.baek2750;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            set.add(Integer.parseInt(br.readLine()));
        }

        List<Integer> list = set.stream().sorted().collect(Collectors.toList());

        for (int i : list) {
            System.out.println(i);
        }
    }
}
