package part3.chap01.baek2798;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int m = scanner.nextInt();
        int result = 0;
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (list.get(i) + list.get(j) + list.get(k) <= m && list.get(i) + list.get(j) + list.get(k) > result) {
                        result = list.get(i) + list.get(j) + list.get(k);
                    }
                    if (result == m) {
                        break;
                    }
                }
            }
        }
        System.out.println(result);

    }
}
