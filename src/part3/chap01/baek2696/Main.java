package part3.chap01.baek2696;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 테스트 케이스 수 입력받기
        for (int i = 0; i < t; i++) {
            int m = sc.nextInt(); // 수열의 크기 입력받기
            int[] arr = new int[m];
            for (int j = 0; j < m; j++) {
                arr[j] = sc.nextInt();
            }
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); // 중앙값보다 작은 값들을 저장할 최대 힙
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 중앙값보다 큰 값들을 저장할 최소 힙
            int cnt = 0; // 출력할 수의 개수
            System.out.println((m + 1) / 2); // 중앙값 출력
            for (int j = 0; j < m; j++) {
                if (maxHeap.isEmpty() || maxHeap.peek() >= arr[j]) {
                    maxHeap.offer(arr[j]);
                } else {
                    minHeap.offer(arr[j]);
                }
                // 최대 힙과 최소 힙의 크기가 같아지도록 조절
                if (maxHeap.size() > minHeap.size() + 1) {
                    minHeap.offer(maxHeap.poll());
                } else if (maxHeap.size() < minHeap.size()) {
                    maxHeap.offer(minHeap.poll());
                }
                // 중앙값 출력
                if (j % 2 == 0) {
                    System.out.print(maxHeap.peek() + " ");
                    cnt++;
                    if (cnt % 10 == 0) {
                        System.out.println();
                    }
                }
            }
            if (cnt % 10 != 0) {
                System.out.println();
            }
        }
        sc.close();
    }
}
