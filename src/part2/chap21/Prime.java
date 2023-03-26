package part2.chap21;

import java.util.*;

// 파이썬 코드를 ChatGpt가 자바로 바꿔줌 미친 기술력;;
public class Prime {
    public static List<Edge> prim(char startNode, List<Edge> edges) {
        List<Edge> mst = new ArrayList<>();
        Map<Character, List<Edge>> adjacentEdges = new HashMap<>();
        for (Edge edge : edges) {
            adjacentEdges.computeIfAbsent(edge.getStartVertex(), k -> new ArrayList<>()).add(edge); // 특정 키에 값이 있는지 확인 후 넣어줌
            adjacentEdges.computeIfAbsent(edge.getEndVertex(), k -> new ArrayList<>()).add(edge);
        }

        Set<Character> connectedNodes = new HashSet<>();
        connectedNodes.add(startNode);
        PriorityQueue<Edge> candidateEdgeList = new PriorityQueue<>(adjacentEdges.get(startNode));

        while (!candidateEdgeList.isEmpty()) {
            Edge edge = candidateEdgeList.poll();
            char n1 = edge.getStartVertex(), n2 = edge.getEndVertex();
            int weight = edge.getValue();

            if (!connectedNodes.contains(n2)) {
                connectedNodes.add(n2);
                mst.add(edge);

                for (Edge nextEdge : adjacentEdges.get(n2)) {
                    char nextNode = nextEdge.getStartVertex() == n2 ? nextEdge.getEndVertex() : nextEdge.getStartVertex();
                    if (!connectedNodes.contains(nextNode)) {
                        candidateEdgeList.offer(nextEdge);
                    }
                }
            }
        }

        return mst;
    }

    public static void main(String[] args) {
        List<Edge> myEdges = Arrays.asList(
                new Edge(7, 'A', 'B'), new Edge(5, 'A', 'D'),
                new Edge(8, 'B', 'C'), new Edge(9, 'B', 'D'), new Edge(7, 'B', 'E'),
                new Edge(5, 'C', 'E'),
                new Edge(7, 'D', 'E'), new Edge(6, 'D', 'F'),
                new Edge(8, 'E', 'F'), new Edge(9, 'E', 'G'),
                new Edge(11, 'F', 'G')
        );
        List<Edge> mst = prim('A', myEdges);
        System.out.println(mst);
    }

}
