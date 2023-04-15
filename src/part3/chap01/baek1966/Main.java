package part3.chap01.baek1966;

import java.util.Scanner;

// 원형 큐로 풀기.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();

        for (int i = 0; i < testCase; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] queue = new int[n];
            int count = 0;
            int popCount = 0;
            for (int j = 0; j < n; j++) {
                queue[j] = scanner.nextInt();
            }

            int queueCount = 0;
            while (popCount != n) {
                int highest = 0;
                // 최고값 찾기
                for (int k = 0; k < n; k++) {
                    if (highest <= queue[k]) {
                        highest = queue[k];
                    }
                }

                // 최고값 pop
                if (highest == queue[queueCount % n]) {
                    queue[queueCount % n] = 0; // 원형 큐
                    popCount++;
                    // pop 한 Index랑 m 이랑 같으면 출력.
                    if ((queueCount % n) == m) {
                        System.out.println(popCount);
                        break;
                    }
                    queueCount++;
                    continue;
                } else queueCount++;
            }
        }
    }
}
