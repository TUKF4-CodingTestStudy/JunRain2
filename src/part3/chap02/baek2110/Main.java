package part3.chap02.baek2110;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();  // 집의 수
        int C = scanner.nextInt();  // 공유기의 수
        List<Integer> houses = new ArrayList<>();  // 집의 좌표를 저장할 리스트
        for (int i = 0; i < N; i++) {
            houses.add(scanner.nextInt());
        }
        Collections.sort(houses);  // 집의 좌표를 오름차순으로 정렬
        int start = 1;  // 최소 거리
        int end = houses.get(N - 1) - houses.get(0);  // 최대 거리
        int result = 0;  // 결과값(최대 거리)
        while (start <= end) {
            int mid = (start + end) / 2;  // 중간 거리
            int count = 1;  // 공유기 설치한 개수
            int prev = houses.get(0);  // 이전에 공유기를 설치한 집의 좌표
            for (int i = 1; i < N; i++) {
                if (houses.get(i) - prev >= mid) {  // 현재 집과 이전 집의 거리가 mid보다 크거나 같으면 공유기 설치
                    count++;
                    prev = houses.get(i);
                }
            }
            if (count >= C) {  // 공유기 설치한 개수가 주어진 개수보다 크거나 같으면 mid 값을 결과값에 저장하고 최소 거리를 증가
                result = mid;
                start = mid + 1;
            } else {  // 공유기 설치한 개수가 주어진 개수보다 작으면 최대 거리를 감소
                end = mid - 1;
            }
        }
        System.out.println(result);  // 결과값 출력
    }
}

// 최소값과 최대값을 줄여나가면서 중간값을 찾기 때문에 이진탐색