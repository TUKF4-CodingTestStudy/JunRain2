package part3.chap01.baek1920;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> list = new HashSet<>();
        String nList = br.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(nList);
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        String mList = br.readLine();
        stringTokenizer = new StringTokenizer(mList);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < m; i++) {
            int check = Integer.parseInt(stringTokenizer.nextToken());
            if (!list.add(check)) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }
        bw.close();
    }
}
