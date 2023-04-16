package part3.chap02.baek1939;

import java.util.*;

public class Main {
    static int N, M;
    static List<Bridge>[] bridges;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();  // 섬의 개수
        M = scanner.nextInt();  // 다리의 개수
        bridges = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            bridges[i] = new ArrayList<>();
        }
        int start = 0;  // 이분 탐색을 위한 최소 중량
        int end = 0;  // 이분 탐색을 위한 최대 중량
        for (int i = 0; i < M; i++) {
            int A = scanner.nextInt();  // 다리의 연결된 섬 1
            int B = scanner.nextInt();  // 다리의 연결된 섬 2
            int C = scanner.nextInt();  // 다리의 중량 제한
            bridges[A].add(new Bridge(B, C));
            bridges[B].add(new Bridge(A, C));
            end = Math.max(end, C);  // 최대 중량 구하기
        }
        int startIsland = scanner.nextInt();  // 시작하는 섬
        int endIsland = scanner.nextInt();  // 도착하는 섬
        int result = 0;  // 결과값(최대 중량)
        while (start <= end) {
            int mid = (start + end) / 2;  // 중간 중량
            boolean[] visited = new boolean[N + 1];  // 방문 여부를 저장할 배열
            if (isPossible(startIsland, endIsland, mid, visited)) {  // 중량이 mid일 때, startIsland에서 endIsland까지 갈 수 있는지 확인
                result = mid;  // 갈 수 있다면 중량값을 결과값에 저장
                start = mid + 1;  // 최소 중량 증가
            } else {
                end = mid - 1;  // 최대 중량 감소
            }
        }
        System.out.println(result);  // 결과값 출력
    }

    // BFS로 startIsland에서 endIsland까지 중량이 weight인 경우 갈 수 있는지 확인하는 메소드
    static boolean isPossible(int startIsland, int endIsland, int weight, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startIsland);
        visited[startIsland] = true;
        while (!queue.isEmpty()) { // 다음으로 갈 섬이 빌때 까지.
            int currentIsland = queue.poll();
            if (currentIsland == endIsland) {  //
                return true;  // 도착 섬에 도달할 수 있다면 true 반환
            }
            for (Bridge nextBridge : bridges[currentIsland]) {  // 다음으로 갈 섬 탐색
                int nextIsland = nextBridge.to;
                int nextWeight = nextBridge.weight;
                if (!visited[nextIsland] && nextWeight >= weight) {  // 중량이 weight(mid)보다 크거나 같아야지만 갈 수 있음
                    visited[nextIsland] = true;
                    queue.add(nextIsland);
                }
            }
        }
        return false;  // 도착 섬에 도달할 수 없다면 false 반환
    }

    // 다리 클래스
    static class Bridge {
        int to;  // 연결된 섬
        int weight;  // 중량 제한

        public Bridge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
