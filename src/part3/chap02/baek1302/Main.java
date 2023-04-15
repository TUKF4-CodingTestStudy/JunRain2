package part3.chap02.baek1302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        while (n-- > 0) {
            String tmp = br.readLine();
            if (!map.containsKey(tmp)) {
                map.put(tmp, 0);
            } else {
                map.put(tmp, map.get(tmp)+1);
            }
        }
        // 맵중 최대값들을 리스트로 뽑아냄.
        List<String> list = map.entrySet().stream().filter(e -> e.getValue().equals(map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue()))
                .map(Map.Entry::getKey).collect(Collectors.toList());

        Collections.sort(list);

        System.out.println(list.get(0));

    }
}
