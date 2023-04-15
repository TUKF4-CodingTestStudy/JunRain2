package part3.chap02.baek1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] num = str.toCharArray();
        ArrayList<Character> list = new ArrayList<>();

        for (char nums : num) {
            list.add(nums);
        }

        Collections.sort(list, Collections.reverseOrder());

        for (char i : list) {
            System.out.printf("%c", i);
        }
    }
}
